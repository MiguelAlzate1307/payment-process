package co.edu.umanizales.payment_process.models;

public class PayPalPayment extends Payment implements Notificable {

    private PayPalAccount account;

    public PayPalPayment(double amount, PayPalAccount account) {
        super(amount);
        this.account = account;
    }

    @Override
    public String paymentProcess() {
        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            return "Pago con PayPal procesado. amount: " + amount;
        } else {
            return "Payment rejected";
        }
    }

    @Override
    public void sendNotification() {
        System.out.println("Notificación: Pago con PayPal realizado.");
    }
}
