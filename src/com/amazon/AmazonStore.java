package com.amazon;

public class AmazonStore {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Adding products to the inventory
        Product laptop = new Product("Laptop", 1000);
        Product phone = new Product("Phone", 800);
        Product tablet = new Product("Tablet", 600);

        inventory.addProduct(laptop, 5);
        inventory.addProduct(phone, 3);
        inventory.addProduct(tablet, 2);

        // Display inventory
        System.out.println("Initial Inventory:");
        inventory.displayInventory();

        // Creating users
        User user1 = new User("Alice");
        User user2 = new User("Bob");
        User user3 = new User("Charlie");

        // Creating orders
        Thread order1 = new Thread(new Order(user1, laptop, 2, inventory));
        Thread order2 = new Thread(new Order(user2, phone, 1, inventory));
        Thread order3 = new Thread(new Order(user3, tablet, 1, inventory));
        Thread order4 = new Thread(new Order(user1, laptop, 1, inventory));
        Thread order5 = new Thread(new Order(user2, tablet, 2, inventory));

        // Starting orders
        order1.start();
        order2.start();
        order3.start();
        order4.start();
        order5.start();

        // Waiting for orders to complete
        try {
            order1.join();
            order2.join();
            order3.join();
            order4.join();
            order5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display final inventory
        System.out.println("Final Inventory:");
        inventory.displayInventory();
    }
}