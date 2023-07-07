package org.example.repository.SpecificationCustom;

import org.example.entiry.UserP;
import org.springframework.data.jpa.domain.Specification;


public interface PeopleSpecification {

    static Specification<UserP> hasOwnerPHONE(String PHONE) {
        return (owner, cq, cb) -> cb.equal(owner.get(PHONE), PHONE);
    }

    static Specification<UserP> ownerLastName(String lastName) {
        return (owner, cq, cb) -> cb.like(owner.get("LAST_NAME"), "%" + lastName + "%");
    }



}
