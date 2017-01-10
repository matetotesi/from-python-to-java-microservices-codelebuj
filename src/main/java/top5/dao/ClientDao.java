package top5.dao;


import top5.model.Client;

public interface ClientDao {
    void addClient(Client client);
    Client findClient(String id);
}
