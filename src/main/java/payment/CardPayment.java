
package payment;

public class CardPayment extends PaymentMethod {

    @Override
    protected boolean doProcess(double amount) {
        System.out.println("Processing Card Payment of R"
                + String.format("%.2f", amount));
        return true;
    }

    @Override
    public String getPaymentType() {
        return "CARD";
    }
}
