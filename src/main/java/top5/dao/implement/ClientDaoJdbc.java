package top5.dao.implement;

import top5.dao.ClientDao;
import top5.model.Client;

import java.sql.*;

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
    public void addClient(Client client) {
        try {
            String query = "INSERT INTO client (client_id, client_name) VALUES(?,?);";
            PreparedStatement safeInput = getConnection().prepareStatement(query);
            safeInput.setString(1,client.getClientKey());
            safeInput.setString(2,client.getClientName());
            safeInput.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public Client findClient(String id) {
        String query = "SELECT * FROM client where client_id =%s" + id;
        Client found = null;
        try {Connection connection = getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);

            if (resultSet.next()) {
                found = new Client(resultSet.getString("client_id"),
                        resultSet.getString("client_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return found;
    }
}
