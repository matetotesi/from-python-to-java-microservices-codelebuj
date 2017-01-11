package top5.model;


import java.time.LocalDate;
import java.util.Date;

public class PaidProducts {

    int productID;
    int quantity;
    Date purchaseTime;
    String clientKey;

    public PaidProducts(int productID, int quantity, Date purchaseTime, String clientKey) {
        this.productID = productID;
        this.quantity = quantity;
        this.purchaseTime = purchaseTime;
        this.clientKey = clientKey;
    }

    public PaidProducts(int productID, int quantity, Date purchaseTime) {
        this.productID = productID;
        this.quantity = quantity;
        this.purchaseTime = purchaseTime;
    }

    public int getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public String getClientKey() {
        return clientKey;
    }
}
