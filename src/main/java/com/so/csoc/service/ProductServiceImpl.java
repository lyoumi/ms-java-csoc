package com.so.csoc.service;

import org.springframework.stereotype.Service;

import com.so.csoc.data.Category;
import com.so.csoc.data.entity.Product;
import com.so.csoc.data.output.ProductOutputPayload;
import com.so.csoc.repository.BookRepository;
import com.so.csoc.repository.LaptopRepository;
import com.so.csoc.repository.PhoneRepository;
import com.so.csoc.repository.TVRepository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private static final String PRODUCT_IGNORE_FILED = "productData";

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final Map<Category, Supplier<List<Map<String, Object>>>> strategyMap;

    public ProductServiceImpl(TVRepository tvRepository,
                            PhoneRepository phoneRepository,
                            BookRepository bookRepository,
                            LaptopRepository laptopRepository) {
        strategyMap = Map.of(
            Category.TV, () ->
                tvRepository.findAll()
                    .stream()
                    .map(o -> OBJECT_MAPPER.convertValue(o, new TypeReference<Map<String, Object>>() {}))
                    .collect(Collectors.toList()),
            Category.BOOKS, () ->
                bookRepository.findAll()
                    .stream()
                    .map(o -> OBJECT_MAPPER.convertValue(o, new TypeReference<Map<String, Object>>() {}))
                    .collect(Collectors.toList()),
            Category.LAPTOPS, () ->
                laptopRepository.findAll()
                    .stream()
                    .map(o -> OBJECT_MAPPER.convertValue(o, new TypeReference<Map<String, Object>>() {}))
                    .collect(Collectors.toList()),
            Category.PHONES, () ->
                phoneRepository.findAll()
                    .stream()
                    .map(o -> OBJECT_MAPPER.convertValue(o, new TypeReference<Map<String, Object>>() {}))
                    .collect(Collectors.toList())
        );
    }

    @Override
    public List<ProductOutputPayload> getProductsByCategoryName(Category category) {
        return buildProductOutputList(category);
    }

    private List<ProductOutputPayload> buildProductOutputList(Category category) {
        final List<Map<String, Object>> productDetails = strategyMap.get(category).get();
        List<ProductOutputPayload> productOutputPayloads = new ArrayList<>();
        productDetails.forEach(product -> {
            final Product productData = (Product) product.get(PRODUCT_IGNORE_FILED);
            ProductOutputPayload payload = new ProductOutputPayload();
            payload.setId(productData.getId());
            payload.setPrice(productData.getPrice());
            payload.setProductDetails(product.keySet().stream()
                .filter(s -> s.equals(PRODUCT_IGNORE_FILED))
                .collect(Collectors.toMap(k -> k, v -> v)));
        });
        return productOutputPayloads;
    }
}
