
package payment;

public class PayJustNowPayment extends PaymentMethod {

    @Override
    protected boolean doProcess(double amount) {
        System.out.println("Processing PayJustNow payment of R"
                + String.format("%.2f", amount));
        return true;
    }

    @Override
    public String getPaymentType() {
        return "Pay Just Now";
    }
}
