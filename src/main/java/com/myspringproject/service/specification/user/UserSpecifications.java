package com.myspringproject.service.specification.user;

import com.myspringproject.dto.user.UserSearchRequest;
import com.myspringproject.entities.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class UserSpecifications {

    public static Specification<User> findByCriteria(UserSearchRequest command) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasText(command.getUsername())) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("username")),
                        command.getUsername().toLowerCase() + "%"));
            }

            if (StringUtils.hasText(command.getFirstName())) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("firstName")),
                        "%" + command.getFirstName().toLowerCase() + "%"));
            }

            if (StringUtils.hasText(command.getLastName())) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("lastName")),
                        "%" + command.getLastName().toLowerCase() + "%"));
            }

            if (command.getStatus() != null) {
                predicates.add(criteriaBuilder.equal(root.get("userStatus"), command.getStatus()));
            }

            if (command.getRole() != null) {
                predicates.add(criteriaBuilder.equal(root.get("role"), command.getRole()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
