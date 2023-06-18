package org.example.repository.SpecificationCustom;

import org.example.entiry.Owner;
import org.example.entiry.Owner_;
import org.springframework.data.jpa.domain.Specification;


public interface OwnerSpecification {

    static Specification<Owner> hasOwnerPHONE(String PHONE) {
        return (owner, cq, cb) -> cb.equal(owner.get(Owner_.PHONE), PHONE);
    }

    static Specification<Owner> titleContains(String lastName) {
        return (owner, cq, cb) -> cb.like(owner.get(Owner_.LAST_NAME), "%" + lastName + "%");
    }
}
