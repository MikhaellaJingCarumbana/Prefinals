package com.example.Prefinals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    @GetMapping
    public List
            <Stock> getAllStocks() {
        return (List
                <Stock>) stockRepository.findAll();
    }

    @PutMapping("/{id}")
    public void modifyStock(@PathVariable("id") int productId, @RequestBody Stock updatedStock) {
        Stock existingStock = stockRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Stock not found with productId: " + productId));
        existingStock.setQuantity(updatedStock.getQuantity());
        existingStock.setShopNo(updatedStock.getShopNo());
        stockRepository.save(existingStock);
    }

    @GetMapping("/{id}")
    public Stock selectStockItem(@PathVariable("id") int productId) {
        return stockRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Stock not found with productId: " + productId));
    }
}
