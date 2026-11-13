package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import payment.CardPayment;
import payment.PayJustNowPayment;
import payment.PaymentMethod;
import payment.WalletPayment;

public class PaymentMethodTest {
    @Test
    void checkoutCanUseDifferentPaymentMethods() {
        PaymentMethod card = new CardPayment();
        PaymentMethod wallet = new WalletPayment();
        PayJustNowPayment payjustnow = new PayJustNowPayment();

        assertTrue(card.processPayment(12400));
        assertTrue(wallet.processPayment(12400));
        assertTrue(payjustnow.processPayment(12400));

        assertEquals("CARD", card.getPaymentType());
        assertEquals("WALLET", wallet.getPaymentType());
        assertEquals("PayJustNow", payjustnow.getPaymentType());
    }
}
