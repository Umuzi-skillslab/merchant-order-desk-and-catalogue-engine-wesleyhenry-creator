
package payment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import domain.Customer;
import domain.Order;
import domain.Product;

public class PaymentMethodTest {

    @Test
    void testCardPayment() {

        Order order = createOrder();

        PaymentMethod paymentMethod = new CardPayment();

        boolean result = order.checkout(paymentMethod);

        assertTrue(result);
        assertEquals("CARD", paymentMethod.getPaymentType());
    }

    @Test
    void testWalletPayment() {

        Order order = createOrder();

        PaymentMethod paymentMethod = new WalletPayment();

        boolean result = order.checkout(paymentMethod);

        assertTrue(result);
        assertEquals("WALLET", paymentMethod.getPaymentType());
    }

    @Test
    void testCorrectAmountPassedToPaymentMethod() {

        Order order = createOrder();

        RecordingPaymentMethod paymentMethod =
                new RecordingPaymentMethod();

        order.checkout(paymentMethod);

        assertEquals(
                order.calculateTotal(),
                paymentMethod.getReceivedAmount(),
                0.001
        );
    }

    @Test
    void testFailedPayment() {

        Order order = createOrder();

        PaymentMethod paymentMethod = new FailedPaymentMethod();

        boolean result = order.checkout(paymentMethod);

        assertFalse(result);
    }

    private Order createOrder() {

        Customer customer = new Customer(
                1,
                "Wesley Henry",
                "wesleyhenry@umuzi.org"
        );

        Product laptop = new Product(1, "Laptop", 12000);
        Product headphones = new Product(2, "Headphones", 1500);

        Order order = new Order(1, customer);

        order.addItem(laptop, 2);
        order.addItem(headphones, 3);

        return order;
    }

    private final class RecordingPaymentMethod extends PaymentMethod {

        private double receivedAmount;

        @Override
        protected boolean doProcess(double amount) {

            receivedAmount = amount;

            return true;
        }

        @Override
        public String getPaymentType() {
            return "TEST";
        }

        public double getReceivedAmount() {
            return receivedAmount;
        }
    }

    private static class FailedPaymentMethod extends PaymentMethod {

        @Override
        protected boolean doProcess(double amount) {
            return false;
        }

        @Override
        public String getPaymentType() {
            return "FAILED PAYMENT";
        }
    }
}
