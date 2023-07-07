package org.example.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.example.entiry.Product;
import org.example.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Api(tags = "Продукты", description = "API для работы с продуктами")
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/page", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Получить список продуктов", notes = "Возвращает список всех продуктов")
    public ResponseEntity<List<Product>> getProductsByPageAndSort(
            @RequestParam(defaultValue = "0", required = false) int offset,
            @RequestParam(defaultValue = "10", required = false) int limit,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String paramsName) {
        log.info("Получить список продуктов");
        return ResponseEntity.ok(productService.getAllProduct(offset, limit, paramsName, search));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Добавление нового продукта")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        log.info("Добавление нового продукта");
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Обновление информации о продукте")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product product) {
        log.info("Обновление информации о продукте");
        return new ResponseEntity<>(productService.createProduct(id, product), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Удаление продукта")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
        log.info("Удаление продукта");
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }


}