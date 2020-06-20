package com.so.csoc.data.input;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductInputPayload {
    @NotBlank(message = "Product id must be present")
    private String id;
}
