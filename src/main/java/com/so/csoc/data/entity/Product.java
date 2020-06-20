package com.so.csoc.data.entity;

import com.so.csoc.data.Category;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id")
    private String id;
    @DecimalMin(value = "0", message = "Price must be greater then '0'")
    @Column(name = "price")
    private BigDecimal price;
    @Min(value = 0, message = "Product count cannot be negative")
    @Column(name = "count")
    private Integer count;
    @Column(name = "category")
    private Category category;
}
