package payment;

public class WalletPayment implements PaymentMethod {

     @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing Wallet payment of R" + String.format("%.2f", amount));
        return true;
    }

    @Override
    public String getPaymentType() {
        return "WALLET";
    }
}
