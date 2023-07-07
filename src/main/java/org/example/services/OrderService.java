package org.example.services;

import org.example.entiry.OrderP;

import java.util.List;

public interface OrderService {
    void deleteOrder(long id);

    OrderP updateOrder(long id, OrderP order);

    OrderP createOrder(OrderP order);

    List<OrderP> getAllOrders(int page, int size, String sortBy, String search);

}
