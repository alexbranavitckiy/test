package org.example.services.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.example.services.PageService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class PageServiceImpl<T> implements PageService<T> {

    @PersistenceContext
    private EntityManager entityManager;

    public List<T> getAllT(Class<T> entityClass, int offset, int limit, List<String> paramsName, List<Specification<T>> specifications) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        Root<T> root = cq.from(entityClass);

        // Создание спецификации на основе параметров
        Specification<T> combinedSpecification = null;
        if (specifications != null && !specifications.isEmpty()) {
            combinedSpecification = specifications.get(0);
            for (int i = 1; i < specifications.size(); i++) {
                combinedSpecification = combinedSpecification.and(specifications.get(i));
            }
        }

        if (combinedSpecification != null) {
            cq.select(root).where(combinedSpecification.toPredicate(root, cq, cb));
        } else {
            cq.select(root);
        }

        // Добавление условий сортировки на основе атрибутов из списка paramsName
        List<Order> orders = new ArrayList<>();
        if (paramsName != null && !paramsName.isEmpty()) {
            for (String paramName : paramsName) {
                if (!paramName.isEmpty()) {
                    Path<?> path = root.get(paramName);
                    orders.add(cb.asc(path));
                }
            }
        } else {
            orders.add(cb.asc(root.get("id"))); // Сортировка по умолчанию, если paramsName пуст или null
        }
        cq.orderBy(orders);

        TypedQuery<T> query = entityManager.createQuery(cq);
        query.setFirstResult(offset);
        query.setMaxResults(limit);

        return query.getResultList();
    }

}
