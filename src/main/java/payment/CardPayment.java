package payment;

public class CardPayment implements PaymentMethod {

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing Card Payment of R" + String.format("%.2f", amount));
        return true;
    }

    @Override
    public String getPaymentType() {
        return "CARD";
    }
}
