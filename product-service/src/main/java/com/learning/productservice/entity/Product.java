package com.learning.productservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
public class Product implements Serializable {

    @Id
    @Column(unique = true)
    private String productId;
    private String title;
    private BigDecimal price;
    private Integer quantity;
}
