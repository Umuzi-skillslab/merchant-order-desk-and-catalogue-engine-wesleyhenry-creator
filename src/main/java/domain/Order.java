package domain;

import java.util.ArrayList;
import java.util.List;

import payment.PaymentMethod;
import payment.PaymentProcessor;


public class Order {

    private final  int id;
    private final  Customer customer;
    private final List<OrderItem> items;

    public Order(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public void addItem(Product product, int quantity) {

        OrderItem orderItem = new OrderItem(product, quantity);
        items.add(orderItem);
    }
    public double calculateTotal() {
        double total = 0.0;
        for (OrderItem item : items) {
            total = total + item.calculateTotal();
        }
        return total;
    }

    public void printSummary() {

System.out.println("Order summary");
System.out.println("========================");
System.out.println("Customer: " + customer.getName());
System.out.println("Email: " + customer.getEmail());
System.out.println("========================");
System.out.println("Order ID: " + id);
System.out.println("Items:");
 for (OrderItem item : items) {
 System.out.println(" - " + item.getProduct().getName() + " | x" + item.getQuantity() + " | R" + String.format("%.2f", item.calculateTotal()));
}

System.out.println("========================");

System.out.println("Total: R" + String.format("%.2f", calculateTotal()));

System.out.println("========================");
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public boolean checkout(PaymentMethod paymentMethod) {
        double totalAmount = calculateTotal();

        boolean paymentSuccessful = new PaymentProcessor().processPayment(paymentMethod, totalAmount);
        System.out.println("=========================");
        if (paymentSuccessful) {
        System.out.println("Payment successful. Order completed.");

        System.out.println("Order ID: " + id);
        System.out.println("Payment Method: " + paymentMethod.getPaymentType());
        System.out.println("Total Amount Paid: R" + String.format("%.2f", totalAmount));
        System.out.println("=========================");

        } else {
            System.out.println("Payment failed. Please try again!");

        }
        return paymentSuccessful;
}
}