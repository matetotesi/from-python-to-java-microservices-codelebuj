package top5.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

import java.io.IOException;


public class Top5APIController {
    private static final Logger logger = LoggerFactory.getLogger(Top5APIController.class);

    public String addProduct(Request request, Response response) throws IOException {
        // validate apikey
        String apiKey = request.params(":apikey");
        // save product to db for client

        // return as JSON
        return "ok";
    }

    public String getTop5(Request request, Response response) throws IOException {
        // validate apikey
        String apiKey = request.params(":apikey");
        // get top5 from db for client

        // return as JSON
        return "dasdasdas";
    }

    public String status(Request request, Response response) throws IOException {
        return "ok";
    }

}
