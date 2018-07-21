package com.serverless;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import java.util.Collections;
import java.util.Map;

import com.serverless.dal.Order;

public class CreateOrderHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {

      try {
          // get the 'body' from input
          JsonNode body = new ObjectMapper().readTree((String) input.get("body"));

          // create the Order object for post
          Order order = new Order();
          // order.setId(body.get("id").asText());
          order.setName(body.get("name").asText());
          order.setPrice((float) body.get("price").asDouble());
          order.save(order);

          // send the response back
              return ApiGatewayResponse.builder()
                      .setStatusCode(200)
                      .setObjectBody(order)
                      .setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & Serverless"))
                      .build();

      } catch (Exception ex) {
          logger.error("Error in saving order: " + ex);

          // send the error response back
                Response responseBody = new Response("Error in saving order: ", input);
                return ApiGatewayResponse.builder()
                        .setStatusCode(500)
                        .setObjectBody(responseBody)
                        .setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & Serverless"))
                        .build();
      }
    }
}
