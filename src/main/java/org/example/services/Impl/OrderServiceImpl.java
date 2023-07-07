package org.example.services.Impl;

import org.example.entiry.OrderP;
import org.example.services.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public void deleteOrder(long id) {

    }

    @Override
    public OrderP updateOrder(long id, OrderP order) {
        return null;
    }

    @Override
    public OrderP createOrder(OrderP order) {
        return null;
    }

    @Override
    public List<OrderP> getAllOrders(int page, int size, String sortBy, String search) {
        return null;
    }
}
