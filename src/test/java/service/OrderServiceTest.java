package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import domain.Customer;
import domain.Order;

public class OrderServiceTest {

    @Test
    void emptyOrderShouldReturnZero() {
        Customer customer =
                new Customer(1, "Wesley", "wesleyhenry@umuzi.org");

        Order order = new Order(1, customer);

        assertEquals(0.0, order.calculateTotal(), 0.0);
    }
}
