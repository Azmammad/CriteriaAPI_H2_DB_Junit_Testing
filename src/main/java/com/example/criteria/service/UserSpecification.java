package com.example.criteria.service;

import com.example.criteria.model.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

    public static Specification<User> filterByUsername(String username) {
        return (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (username == null || username.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("username"), username);
        };
    }

    public static Specification<User> filterByAge(Integer age){
        return (Root<User> root,CriteriaQuery<?> query,CriteriaBuilder criteriaBuilder)->{
            if (age==null){
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.greaterThan(root.get("age"),age);
        };
    }
}
