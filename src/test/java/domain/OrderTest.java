package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import payment.PaymentMethod;

public class OrderTest {

    @Test
    void calculateTotalReturnsGrandTotal() {

        Customer customer =
                new Customer(1, "Wesley","wesleyhenry@umuzi.org");

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

    @Test
    void checkoutProcessesPaymentForOrderTotal() {
        Customer customer = new Customer(1, "Wesley", "wesleyhenry@umuzi.org");
        Order order = new Order(1001, customer);
        order.addItem(new Product(1, "Laptop", 12000), 1);
        order.addItem(new Product(2, "Mouse", 200), 2);

        double[] processedAmount = {Double.NaN};
        PaymentMethod paymentMethod = new PaymentMethod() {
            @Override
            public boolean processPayment(double amount) {
                processedAmount[0] = amount;
                return true;
            }

            @Override
            public String getPaymentType() {
                return "TEST";
            }
        };

        order.checkout(paymentMethod);

        assertEquals(12400, processedAmount[0]);
    }
}