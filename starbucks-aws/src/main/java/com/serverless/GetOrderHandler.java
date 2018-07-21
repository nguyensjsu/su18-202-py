package com.serverless;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import java.util.Collections;
import java.util.Map;

import com.serverless.dal.Order;

public class GetOrderHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {

    try {
        // get the 'pathParameters' from input
        Map<String,String> pathParameters =  (Map<String,String>)input.get("pathParameters");
        String orderId = pathParameters.get("id");

        // get the Order by id
        Order order = new Order().get(orderId);

        // send the response back
        if (order != null) {
          return ApiGatewayResponse.builder()
                      .setStatusCode(200)
                      .setObjectBody(order)
                      .setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & Serverless"))
                      .build();
        } else {
          return ApiGatewayResponse.builder()
                      .setStatusCode(404)
              .setObjectBody("order with id: '" + orderId + "' not found.")
                      .setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & Serverless"))
                      .build();
        }
    } catch (Exception ex) {
        logger.error("Error in retrieving order: " + ex);

        // send the error response back
              Response responseBody = new Response("Error in retrieving order: ", input);
              return ApiGatewayResponse.builder()
                      .setStatusCode(500)
                      .setObjectBody(responseBody)
                      .setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & Serverless"))
                      .build();
    }
    }
}
