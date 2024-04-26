package com.example.Prefinals;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Stock {
    @Id
    private int productId;
    private int quantity;
    private int shopNo;

    // Constructors, getters, and setters

    public Stock() {}

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getShopNo() {
        return shopNo;
    }

    public void setShopNo(int shopNo) {
        this.shopNo = shopNo;
    }

    // Methods

    public void addStock() {
        // Logic to add stock
    }

    public void modifyStock(int productId) {
        // Logic to modify stock
    }

    public void selectStockItem(int productId) {
        // Logic to select stock item
    }
}
