package top5.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

import java.io.IOException;

public class Top5APIController {
    private static final Logger logger = LoggerFactory.getLogger(Top5APIController.class);

    public String status(Request request, Response response) throws IOException {
        return "ok";
    }

}
