package com.so.csoc.service;

import com.so.csoc.data.Category;
import com.so.csoc.data.output.ProductOutputPayload;
import java.util.List;

public interface ProductService {

    List<ProductOutputPayload> getProductsByCategoryName(Category category);
}
