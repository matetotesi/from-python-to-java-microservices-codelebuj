package top5.dao.implement;

import top5.dao.ClientDao;
import top5.model.Client;

import java.sql.Connection;
import java.sql.SQLException;

public class ClientDaoJdbc extends ConnectionDB implements ClientDao {

    @Override
    public Connection getConnection() throws SQLException {
        return super.getConnection();
    }

    @Override
    public void executeQuery(String query) {
        super.executeQuery(query);
    }

    private static ClientDaoJdbc instance = null;

    public static ClientDaoJdbc getInstance() {
        if (instance == null) {
            instance = new ClientDaoJdbc();
        }
        return instance;
    }

    @Override
    public String addClient(){
        return "ok";
    }

    @Override
    public String findClient(){
        return "ok";
    }

}
