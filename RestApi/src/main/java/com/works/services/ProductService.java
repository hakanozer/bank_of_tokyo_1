package com.works.services;

import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;
    final CacheManager cacheManager;

    public ResponseEntity save(Product product) {
        productRepository.save(product);
        cacheManager.getCache("product").clear();
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @Cacheable("product")
    public ResponseEntity list() {
        return new ResponseEntity(productRepository.findAll(), HttpStatus.OK);
    }

}
