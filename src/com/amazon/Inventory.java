package com.amazon;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Product, Integer> products;

    public Inventory() {
        products = new HashMap<>();
    }

    public synchronized void addProduct(Product product, int quantity) {
        products.put(product, products.getOrDefault(product, 0) + quantity);
    }

    public synchronized boolean purchaseProduct(Product product, int quantity) {
        if (products.containsKey(product) && products.get(product) >= quantity) {
            products.put(product, products.get(product) - quantity);
            return true;
        }
        return false;
    }

    public void displayInventory() {
        products.forEach((product, quantity) -> {
            System.out.println(product.getName() + ": " + quantity + " units available at $" + product.getPrice());
        });
    }
}