package com.example.Prefinals;

import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository
        <Stock, Integer> {
    // Add custom query methods if needed
}
