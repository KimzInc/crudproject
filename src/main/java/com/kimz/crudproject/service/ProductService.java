package com.kimz.crudproject.service;

import com.kimz.crudproject.entity.Product;
import com.kimz.crudproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    //inject repository using autowired
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product){
        return repository.save(product);
    }

    //saving list of products
    public List<Product> saveListProduct(List<Product> products){
        return repository.saveAll(products);
    }

    //fetching all the products
    public List<Product> getProducts(){
        return repository.findAll();
    }

    //fetching a single product
    public Product getProduct(int id){
        return repository.findById(id).orElse(null); //return null if no product is found
    }

    public Product getProductByName(String name){
        return repository.findByName(name);
    }

    public String deleteProduct(int id){
        repository.deleteById(id);
        return "Product removed!! "+ id;
    }

    public Product updateProduct(Product product){
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }

}
