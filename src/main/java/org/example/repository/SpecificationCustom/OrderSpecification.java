package org.example.repository.SpecificationCustom;

import org.example.entiry.OrderP;
import org.springframework.data.jpa.domain.Specification;

public interface OrderSpecification {

    static Specification<OrderP> hasOwnerPHONE(String PHONE) {
        return (owner, cq, cb) -> cb.equal(owner.get(PHONE), PHONE);
    }



}
