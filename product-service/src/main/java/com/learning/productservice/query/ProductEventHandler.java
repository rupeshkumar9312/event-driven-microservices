package com.learning.productservice.query;

import com.learning.productservice.core.events.ProductCreatedEvent;
import com.learning.productservice.entity.Product;
import com.learning.productservice.repository.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductEventHandler {

    @Autowired
    private ProductRepository productRepository;

    @EventHandler
    public void on(ProductCreatedEvent productCreatedEvent) {
        Product product = new Product();
        BeanUtils.copyProperties(productCreatedEvent, product);
        productRepository.save(product);
    }

}