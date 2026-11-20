
package payment;

public class EftPayment extends PaymentMethod {

    @Override
    protected boolean doProcess(double amount) {
        System.out.println("Processing EFT payment of R"
                + String.format("%.2f", amount));
        return true;
    }

    @Override
    public String getPaymentType() {
        return "EFT";
    }
}
