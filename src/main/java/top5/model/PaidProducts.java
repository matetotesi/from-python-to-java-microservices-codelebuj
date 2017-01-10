package top5.model;


import java.util.Date;

public class PaidProducts {

    int productID;
    int quantity;
    Date purchaseTime;
    Client clientKey;

    public PaidProducts(int productID, int quantity, Date purchaseTime, Client clientKey) {
        this.productID = productID;
        this.quantity = quantity;
        this.purchaseTime = purchaseTime;
        this.clientKey = clientKey;
    }

}
