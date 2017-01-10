package top5.dao.implement;


import top5.dao.PaidProductDao;
import top5.model.Client;
import top5.model.PaidProducts;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    
    public void addPaidProducts(PaidProducts paidProduct){
        String query = "INSERT INTO paid_products (product_id, quantity, purchase_time, client_identifier)" +
                "VALUES ('" + paidProduct.getProductID() + "','" + paidProduct.getQuantity() + "','" + paidProduct.getPurchaseTime() +"', "+ paidProduct.getClientKey()+");";
        executeQuery(query);
    }

    @Override
    public PaidProducts findPaidProducts(PaidProducts paidProducts) {
        String query = "SELECT DISTINCT product_id, Sum(quantity), purchase_time FROM paid_products group by product_id, purchase_time ORDER BY purchase_time DESC, Sum(quantity) DESC, product_id LIMIT 5";
        PaidProducts found = null;
        try {Connection connection = getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);

            if (resultSet.next()) {
                Client client = new Client(
                        resultSet.getString("client_identifier"),
                        resultSet.getString("client_name"));

                found = new PaidProducts(
                        resultSet.getInt("product_id"),
                        resultSet.getInt("quantity"),
                        resultSet.getDate("purchase_time"),
                        client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return found;
    }

}
