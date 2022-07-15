package com.learning.productservice.controller;

import com.learning.productservice.entity.Product;
import com.learning.productservice.query.FindProductQuery;
import org.axonframework.messaging.responsetypes.ResponseType;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<Product> getProducts(){
        FindProductQuery query = new FindProductQuery();
        var result = queryGateway.query(query, ResponseTypes.multipleInstancesOf(Product.class)).join();
        return result;
    }

}
