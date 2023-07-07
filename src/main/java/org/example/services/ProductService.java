package org.example.services;

import org.example.entiry.OrderP;
import org.example.entiry.Product;

import java.util.List;

public interface ProductService {


    List<Product> getAllProduct(int offset, int limit, String paramsName, String search);

    Product createProduct(Product product);

    Product createProduct(long id, Product product);

    void deleteProduct(long id);
}
