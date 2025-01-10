package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Product;
import com.example.demo.repositories.productRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping(value = "/Products")
public class demoController {

    @Autowired
    private productRepository repository;

    @GetMapping
    public List<Product> findAll(){
        List<Product> result = repository.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public Product findById(@PathVariable long id){
        Product result = repository.findById(id).get();
        return result;
    }

    @PostMapping
    public Product insert(@RequestBody Product product){
        Product result = repository.save(product);
        return result;
    }
    
}
