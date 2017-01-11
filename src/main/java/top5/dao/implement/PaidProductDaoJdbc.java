package top5.dao.implement;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import top5.dao.PaidProductDao;
import top5.model.Client;
import top5.model.PaidProducts;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaidProductDaoJdbc extends ConnectionDB implements PaidProductDao {

    @Override
    public Connection getConnection() throws SQLException {
        return super.getConnection();
    }

    @Override
    public void executeQuery(String query) {
        super.executeQuery(query);
    }

    private static PaidProductDaoJdbc instance = null;

    public static PaidProductDaoJdbc getInstance() {
        if (instance == null) {
            instance = new PaidProductDaoJdbc();
        }
        return instance;
    }

    @Override
    public void addPaidProducts(PaidProducts paidProduct){
        String query = "INSERT INTO paid_products (product_id, quantity, purchase_time, client_identifier)" +
                "VALUES (" + paidProduct.getProductID() + "," + paidProduct.getQuantity() + ",'" + paidProduct.getPurchaseTime() +"','"+ paidProduct.getClientKey()+"');";

        System.out.println("WTF" + query);
        executeQuery(query);
    }

    @Override
    public Map findPaidProducts() {
        String query = "SELECT DISTINCT product_id, Sum(quantity) AS quantity, purchase_time FROM paid_products group by product_id, purchase_time ORDER BY purchase_time DESC, Sum(quantity) DESC, product_id LIMIT 5;";
        PaidProducts found = null;
        JSONObject jsonObject = new JSONObject();
        Map<String, JSONArray> top5 = new HashMap<>();
        JSONArray obj = new JSONArray();


        try {Connection connection = getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);

            while (resultSet.next()) {

                found = new PaidProducts(
                        resultSet.getInt("product_id"),
                        resultSet.getInt("quantity"),
                        resultSet.getDate("purchase_time"));

                jsonObject.put("product", found.getProductID());
                jsonObject.put("quantity", found.getQuantity());
                jsonObject.put("time", found.getPurchaseTime());
                obj.add(jsonObject);
                top5.put("products", obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return top5;
    }

}
