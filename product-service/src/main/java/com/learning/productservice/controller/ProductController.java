package com.learning.productservice.controller;

import com.learning.productservice.command.CreateProductCommand;
import com.learning.productservice.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addProduct(@RequestBody Product product) {
        var createdCommand = CreateProductCommand.builder()
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .title(product.getTitle())
                .productId(UUID.randomUUID().toString())
                .build();
        String returnValue = "";
        try {
            returnValue = commandGateway.sendAndWait(createdCommand);
        }catch (Exception ex){
            returnValue = ex.getLocalizedMessage();
        }
        return returnValue;
    }

    @GetMapping("/{productId}")
    public String getProduct() {
        log.info("Get Method Called");
        return "Get Method Called";
    }

    @PutMapping("/{productId}")
    public String updateProduct() {
        return "Put Method Called";
    }

    @DeleteMapping
    public String deleteProduct() {
        return "Delete Method Called";
    }
}
