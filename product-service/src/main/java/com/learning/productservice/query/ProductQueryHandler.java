package com.learning.productservice.query;

import com.learning.productservice.entity.Product;
import com.learning.productservice.repository.ProductRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductQueryHandler {

    @Autowired
    private ProductRepository productRepository;

    @QueryHandler
    public List<Product> findProducts(FindProductQuery findProductQuery){
        var products = productRepository.findAll();
        return products;
    }
}
