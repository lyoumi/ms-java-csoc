package com.so.csoc.data.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Data
@Entity(name = "laptop")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id")
    private String id;
    @NotBlank(message = "Model name must not be empty")
    @Column(name = "model")
    private String model;
    @NotBlank(message = "Brand name must not be empty")
    @Column(name = "brand")
    private String brand;
    @Min(value = 0, message = "Flash size must be greater then '0'")
    @Column(name = "flash_size")
    private Integer flashSize;
    @NotBlank(message = "Processor name must not be empty")
    @Column(name = "processor")
    private String processor;
    @Min(value = 0, message = "RAM must be greater than '0'")
    @Column(name = "ram_size")
    private Integer ramSize;
    @Column(name = "graphic_adapter")
    private String graphicAdapter;
    @Column(name = "display_type")
    private String displayType;
    @OneToOne(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product productData;
}
