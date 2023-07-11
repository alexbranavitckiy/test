package org.example.services.Impl;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.entiry.OrderP;
import org.example.repository.OrderRepository;
import org.example.services.OrderService;
import org.example.services.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final PageService<OrderP> pageService;


    @PersistenceContext
    private EntityManager entityManager;

    private CriteriaBuilder cb;

    @PostConstruct
    private void initializeCriteriaBuilder() {
        cb = entityManager.getCriteriaBuilder();
    }

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, PageService<OrderP> pageService) {
        this.pageService = pageService;
        this.orderRepository = orderRepository;
    }


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
    public List<OrderP> getAllOrders(int offset, int limit, String sortBy, String search) {
        return null;//pageService.getAllT(OrderP.class, offset, limit, List.of("id"), List.of(totalAmount(search)));
    }

    public Specification<OrderP> totalAmount(BigDecimal amount) {
        return (root, query, cb) -> cb.equal(root.get("totalAmount"), amount);
    }


}
