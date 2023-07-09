package org.example.services;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface PageService<T> {

    List<T> getAllT(Class<T> entityClass, int offset, int limit, List<String> paramsName, List<Specification<T>> specifications);

}
