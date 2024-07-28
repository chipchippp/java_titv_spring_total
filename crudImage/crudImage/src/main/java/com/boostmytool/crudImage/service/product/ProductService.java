package com.boostmytool.crudImage.service.product;

import com.boostmytool.crudImage.enity.Product;
import com.boostmytool.crudImage.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll(Sort sort) {
        return productRepository.findAll(sort);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        Product productToUpdate = productRepository.findById(product.getId()).orElse(null);
        if (productToUpdate != null) {
            productToUpdate.setName(product.getName());
            productToUpdate.setBrand(product.getBrand());
            productToUpdate.setCategory(product.getCategory());
            productToUpdate.setDescription(product.getDescription());
            productToUpdate.setPrice(product.getPrice());
            productToUpdate.setImageFileName(product.getImageFileName());
            productRepository.save(productToUpdate);
        }
    }


    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
