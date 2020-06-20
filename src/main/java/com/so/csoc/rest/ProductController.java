package com.so.csoc.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.so.csoc.data.Category;
import com.so.csoc.data.output.ProductOutputPayload;
import com.so.csoc.service.ProductService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductOutputPayload> getProductsByCategory(@RequestParam("category") Category category) {
        return productService.getProductsByCategoryName(category);
    }
}
