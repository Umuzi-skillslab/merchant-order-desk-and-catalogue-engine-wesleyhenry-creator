package payment;

public abstract class PaymentMethod {

    public boolean processPayment(double amount) {
        if (!isValidAmount(amount)) {
            System.out.println("Rejected: Amount must be over R0.00");
            return false;
        }

        return doProcess(amount);
    }

    protected boolean isValidAmount(double amount) {
        return amount > 0;
    }

    protected abstract boolean doProcess(double amount);

    public abstract String getPaymentType();
}