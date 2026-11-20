
package payment;

public class WalletPayment extends PaymentMethod {

    @Override
    protected boolean doProcess(double amount) {
        System.out.println("Processing Wallet payment of R"
                + String.format("%.2f", amount));
        return true;
    }

    @Override
    public String getPaymentType() {
        return "WALLET";
    }
}
