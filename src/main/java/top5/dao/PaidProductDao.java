package top5.dao;


import top5.model.PaidProducts;

public interface PaidProductDao {
    void addPaidProducts(PaidProducts client);
    PaidProducts findPaidProducts(PaidProducts paidProducts);
}
