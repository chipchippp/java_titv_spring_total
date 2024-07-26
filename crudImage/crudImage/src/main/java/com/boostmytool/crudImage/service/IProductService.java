package com.boostmytool.crudImage.service;

import com.boostmytool.crudImage.enity.Product;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IProductService {
    List<Product> findAll(Sort sort);
    Product findById(Long id);
    Product save(Product product);
    void update(Product product);
    void deleteById(Long id);
}
