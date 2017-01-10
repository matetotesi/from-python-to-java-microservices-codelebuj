package top5.model;

public class Client {

    private String clientKey;

    public Client (String clientKey){
        this.clientKey = clientKey;

    }

    public String getClientKey() {
        return clientKey;
    }

    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }
}
