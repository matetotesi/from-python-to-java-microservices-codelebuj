package top5.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.client.utils.URIBuilder;


public class Top5APIController {
    private static final Logger logger = LoggerFactory.getLogger(Top5APIController.class);
    private static final String SERVICE_URL = "http://localhost:60001";
    private static final String API_KEY = "2e4tg";



    public String status(Request request, Response response) throws IOException {
        return "ok";
    }

    /*private String execute(String url) throws IOException, URISyntaxException {
        URI uri = new URIBuilder(SERVICE_URL + url).build();
        return Request.Get(uri).execute().returnContent().asString();
    }*/

}
