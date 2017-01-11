package top5.controller;


import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
import top5.dao.ClientDao;
import top5.dao.PaidProductDao;
import top5.dao.implement.ClientDaoJdbc;
import top5.dao.implement.PaidProductDaoJdbc;
import top5.model.Client;
import top5.model.PaidProducts;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Top5APIController {
    private static final Logger logger = LoggerFactory.getLogger(Top5APIController.class);
    private static ClientDao clientDao = new ClientDaoJdbc();
    private static PaidProductDao paidProductDao = new PaidProductDaoJdbc();

    public String addProduct(Request request, Response response) throws IOException {
        LocalDate localDate = LocalDate.now();
        Date date = java.sql.Date.valueOf(localDate);
        if (!clientDao.findClient(request.params(":apikey")).equals(null)){
            paidProductDao.addPaidProducts(new PaidProducts(007,121, date, request.params(":apikey")));
        }
        return "ok";
    }

    public String getTop5(Request request, Response response) throws IOException {

        System.out.println("JSON " + paidProductDao.findPaidProducts());
        return "Done";
    }


    public String status(Request request, Response response) throws IOException {
        return "ok";
    }

}
