package com.so.csoc.data.output;

import java.math.BigDecimal;
import java.util.Map;
import lombok.Data;

@Data
public class ProductOutputPayload {
    private String id;
    private BigDecimal price;
    private Map<String, String> productDetails;
}
