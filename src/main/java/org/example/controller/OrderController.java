package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.example.entiry.OrderP;
import org.example.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/order")
@Api(tags = "Заказы", description = "API для работы с заказами")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Получить список заказов", notes = "Возвращает список всех заказов")
    public ResponseEntity<List<OrderP>> getAllOrders(
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int size,
            @RequestParam(defaultValue = "id", required = false) String sortBy,
            @RequestParam(defaultValue = " ", required = false) String search) {
        log.info("Получить список заказов");
        return ResponseEntity.ok(orderService.getAllOrders(page, size, sortBy, search));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Создать новый заказ")
    public ResponseEntity<OrderP> createOrder(@RequestBody OrderP order) {
        log.info("Создать новый заказ");
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(order));
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Обновить информацию о заказе")
    public ResponseEntity<OrderP> updateOrder(@PathVariable long id, @RequestBody OrderP order) {
        log.info("Обновить информацию о заказе");
        return ResponseEntity.ok(orderService.updateOrder(id, order));
    }

    @DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Удалить заказ")
    public ResponseEntity<Void> deleteOrder(@PathVariable long id) {
        log.info("Удалить заказ");
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }

}
