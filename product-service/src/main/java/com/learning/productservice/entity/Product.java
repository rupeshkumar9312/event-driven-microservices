package com.learning.productservice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
public class Product {

    private String title;

    private BigDecimal price;

    private Integer quantity;
}
