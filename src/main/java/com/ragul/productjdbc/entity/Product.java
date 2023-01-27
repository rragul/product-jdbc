package com.ragul.productjdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

 @Data
 @AllArgsConstructor
 @NoArgsConstructor
public class Product {
     @Id
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;
}
