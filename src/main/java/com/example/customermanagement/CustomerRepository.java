package com.example.customermanagement;

import jakarta.persistence.EntityManager;

public class CustomerRepository {

    private final EntityManager entityManager;

    public CustomerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Customer customer) {
        entityManager.persist(customer);
    }
}
