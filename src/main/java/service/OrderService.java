package service;
 
import domain.Customer;
import domain.Order;
import domain.Product;
 

public class OrderService {
 
    public Order createOrder(int orderId, Customer customer) {
        return new Order(orderId, customer);
    }

    public void addProductsToOrder(Order order, Product product, int quantity) {
        order.addItem(product, quantity);
    }

    public double calculateTotals(Order order) {
        return order.calculateTotal();
    }
}
 