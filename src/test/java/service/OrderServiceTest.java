package service;
 
import domain.Customer;
import domain.Order;
import domain.Product;

import org.junit.jupiter.api.Test;
 
import static org.junit.jupiter.api.Assertions.*;
 
public class OrderServiceTest {
 
   @Test
void emptyOrderShouldReturnZero() {
    Customer customer =
            new Customer(1, "Wesley", "wesleyhenry@umuzi.org");

    Order order = new Order(1, customer);

    assertEquals(0.0, order.calculateTotal());
}
}
 