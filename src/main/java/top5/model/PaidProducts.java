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

    public PaidProducts(int productID, int quantity) {
        this.productID = productID;
        this.quantity = quantity;
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

    @Override
    public String toString() {
        return "PaidProducts{" +
                "productID=" + productID +
                ", quantity=" + quantity +
                ", purchaseTime=" + purchaseTime +
                ", clientKey='" + clientKey + '\'' +
                '}';
    }
}
