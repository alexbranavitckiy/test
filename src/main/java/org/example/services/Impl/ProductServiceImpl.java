package org.example.services.Impl;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.entiry.Product;
import org.example.repository.ProductRepository;
import org.example.services.PageService;
import org.example.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;
    private final PageService<Product> pageService;
    @PersistenceContext
    private EntityManager entityManager;

    private CriteriaBuilder cb;

    @PostConstruct
    private void initializeCriteriaBuilder() {
        cb = entityManager.getCriteriaBuilder();
    }


    @Autowired
    public ProductServiceImpl(PageService<Product> pageService, ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.pageService = pageService;
    }

    @Override
    public List<Product> getAllProduct(int offset, int limit, String sort, String search) {
        return pageService.getAllT(Product.class, offset, limit, List.of(sort), List.of(), List.of());
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product createProduct(long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(long id) {

    }


}
