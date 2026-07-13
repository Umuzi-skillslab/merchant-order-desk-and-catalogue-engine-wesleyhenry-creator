package domain;

import java.util.ArrayList;
import java.util.List;


public class Order {

    private  int id;
    private  Customer customer;
    private  List<OrderItem> items;

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
 System.out.println(" - " + item.getProduct().getName() + " | x" + item.getQuantity() + " | R" + String.format("%.0f", item.calculateTotal()));
}

System.out.println("========================");

System.out.println("Total: R" + String.format("%.0f", calculateTotal()));

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
}

