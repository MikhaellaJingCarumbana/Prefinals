package com.example.Prefinals;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    // Add custom query methods if needed
}
