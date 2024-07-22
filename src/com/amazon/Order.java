package com.amazon;

public class Order implements Runnable {
    private User user;
    private Product product;
    private int quantity;
    private Inventory inventory;

    public Order(User user, Product product, int quantity, Inventory inventory) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.inventory = inventory;
    }

    @Override
    public void run() {
        synchronized (inventory) {
            if (inventory.purchaseProduct(product, quantity)) {
                System.out.println(user.getName() + " successfully purchased " + quantity + " unit(s) of " + product.getName());
            } else {
                System.out.println(user.getName() + " failed to purchase " + quantity + " unit(s) of " + product.getName() + " (out of stock)");
            }
        }
    }
}