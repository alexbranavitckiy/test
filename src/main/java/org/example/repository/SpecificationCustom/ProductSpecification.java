package org.example.repository.SpecificationCustom;

import org.example.entiry.Product;
import org.example.entiry.Product_;
import org.example.entiry.UserP;
import org.springframework.data.jpa.domain.Specification;

public interface ProductSpecification {

    static Specification<Product> category(String category) {
        return (owner, cq, cb) -> cb.like(owner.get(Product_.CATEGORY), "%" + category + "%");
    }


}
