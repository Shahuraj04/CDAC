package com.ecommerce.core;

public class OrderItem {
    private Customer customer;
    private Product product;
    private int quantity;
    private double totalPrice;

    public OrderItem(Customer customer, Product product, int quantity, double totalPrice) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderItem [customer=" + customer.getCustName() + 
               ", product=" + product.getPrdName() +
               ", quantity=" + quantity + 
               ", totalPrice=" + totalPrice + "]";
    }
}
