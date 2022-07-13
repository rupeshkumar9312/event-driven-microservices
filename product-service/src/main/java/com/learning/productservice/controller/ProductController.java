package com.learning.productservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {

    @PostMapping
    public String addProduct(){
        return "Post Method Called";
    }

    @GetMapping("/{productId}")
    public String getProduct(){
        log.info("Get Method Called");
        return "Get Method Called";
    }

    @PutMapping("/{productId}")
    public String updateProduct(){
        return "Put Method Called";
    }

    @DeleteMapping
    public String deleteProduct(){
        return "Delete Method Called";
    }
}
