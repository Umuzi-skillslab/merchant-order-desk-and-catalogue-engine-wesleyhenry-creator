package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import domain.Customer;
import domain.Order;
import domain.Product;

public class OrderServiceTest {

    @Test
    void createOrderAddItemsAndCheckout() {
        OrderService orderService = new OrderService();

        Customer customer = new Customer(1001, "Wesley Henry", "wesleyhenry@umuzi.org");
        Order order = orderService.createOrder(1, customer);

        Product laptop = new Product(1, "Laptop", 12000);
        Product mouse = new Product(2, "Mouse", 200);
        Product headphones = new Product(3, "Headphones", 1500);


        orderService.addProductsToOrder(order, laptop, 1);
        orderService.addProductsToOrder(order, mouse, 2);
        orderService.addProductsToOrder(order, headphones, 3);

        assertEquals(3, order.getItems().size());
        assertEquals(16900, order.calculateTotal());
    }
}
