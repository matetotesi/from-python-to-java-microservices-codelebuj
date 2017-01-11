package top5.dao;


import org.json.simple.JSONObject;
import top5.model.PaidProducts;

import java.util.Map;

public interface PaidProductDao {
    void addPaidProducts(PaidProducts client);
    Map findPaidProducts();
}
