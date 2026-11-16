package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class OrderTest {

    @Test
    void calculateTotalReturnsGrandTotal() {

        Customer customer = new Customer(1, "Wesley Henry","wesleyhenry@umuzi.org");

        Order order = new Order(1001, customer);

        Product laptop =
                new Product(1,"Laptop", 12000);

        Product mouse =
                new Product(2, "Mouse", 200);

        Product headphones =
                new Product(3, "Headphones", 1500);

        order.addItem(laptop, 1);
        order.addItem(mouse, 2);
        order.addItem(headphones, 5);

        assertEquals(19900, order.calculateTotal());
    }
    }