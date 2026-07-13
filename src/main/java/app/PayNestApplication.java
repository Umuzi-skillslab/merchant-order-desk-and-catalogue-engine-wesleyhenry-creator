package app;

import domain.Customer;
import domain.Order;
import domain.Product;


public class PayNestApplication {

    public static void main(String[] args) {
        
        Product laptop = new Product(1, "Laptop", 12000);
        Product mouse = new Product(2, "Mouse", 200);
        Product headphones = new Product(3, "Headphones", 1500);

        Customer customer = new Customer(1, "Wesley Henry", "wesleyhenry@umuzi.org");

        Order order = new Order(1, customer);
        order.addItem(laptop, 1);
        order.addItem(mouse, 2);
        order.addItem(headphones, 5);

        order.printSummary();   
    }
}
