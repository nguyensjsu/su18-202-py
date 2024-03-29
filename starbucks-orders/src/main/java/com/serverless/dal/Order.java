package com.serverless.dal;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.TableNameOverride;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

@DynamoDBTable(tableName = "PLACEHOLDER_ORDERS_TABLE_NAME")
public class Order {

    // get the table name from env. var. set in serverless.yml
    private static final String ORDERS_TABLE_NAME = System.getenv("ORDERS_TABLE_NAME");

    private static DynamoDBAdapter db_adapter;
    private final AmazonDynamoDB client;
    private final DynamoDBMapper mapper;

    private Logger logger = Logger.getLogger(this.getClass());

    private String id;
    private String name;
    private Float price;

    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBRangeKey(attributeName = "name")
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBAttribute(attributeName = "price")
    public Float getPrice() {
        return this.price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }

    public Order() {
        // build the mapper config
        DynamoDBMapperConfig mapperConfig = DynamoDBMapperConfig.builder()
            .withTableNameOverride(new DynamoDBMapperConfig.TableNameOverride(ORDERS_TABLE_NAME))
            .build();
        // get the db adapter
        this.db_adapter = DynamoDBAdapter.getInstance();
        this.client = this.db_adapter.getDbClient();
        // create the mapper with config
        this.mapper = this.db_adapter.createDbMapper(mapperConfig);
    }

    public String toString() {
        return String.format("Order [id=%s, name=%s, price=$%f]", this.id, this.name, this.price);
    }

    // methods
    public Boolean ifTableExists() {
        return this.client.describeTable(ORDERS_TABLE_NAME).getTable().getTableStatus().equals("ACTIVE");
    }

    public List<Order> list() throws IOException {
      DynamoDBScanExpression scanExp = new DynamoDBScanExpression();
      List<Order> results = this.mapper.scan(Order.class, scanExp);
      for (Order p : results) {
        logger.info("Orders - list(): " + p.toString());
      }
      return results;
    }

    public Order get(String id) throws IOException {
        Order order = null;

        HashMap<String, AttributeValue> av = new HashMap<String, AttributeValue>();
        av.put(":v1", new AttributeValue().withS(id));

        DynamoDBQueryExpression<Order> queryExp = new DynamoDBQueryExpression<Order>()
            .withKeyConditionExpression("id = :v1")
            .withExpressionAttributeValues(av);

        PaginatedQueryList<Order> result = this.mapper.query(Order.class, queryExp);
        if (result.size() > 0) {
          order = result.get(0);
          logger.info("Orders - get(): order - " + order.toString());
        } else {
          logger.info("Orders - get(): order - Not Found.");
        }
        return order;
    }

    public void save(Order order) throws IOException {
        logger.info("Orders - save(): " + order.toString());
        this.mapper.save(order);
    }

    public Boolean delete(String id) throws IOException {
        Order order = null;

        // get order if exists
        order = get(id);
        if (order != null) {
          logger.info("Orders - delete(): " + order.toString());
          this.mapper.delete(order);
        } else {
          logger.info("Orders - delete(): Order - does not exist.");
          return false;
        }
        return true;
    }

}
