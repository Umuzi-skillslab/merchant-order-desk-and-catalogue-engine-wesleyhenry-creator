package payment;

public class WalletPayment implements PaymentMethod {

    @Override
    public boolean processPayment(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid payment amount: R" + String.format("%.0f", amount));
            return false;
        }
    System.out.println("Processing Wallet payment for R" +
            String.format("%.0f", amount));
        return true;
    }

    @Override
    public String getPaymentType() {
        return "WALLET";
    }
}