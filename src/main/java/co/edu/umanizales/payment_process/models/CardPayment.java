package co.edu.umanizales.payment_process.models;

public class CardPayment extends Payment implements Notificable {
    private Card card;

    public CardPayment(double amount, Card card) {
        super(amount);
        this.card = card;
    }

    @Override
    public String paymentProcess() {
        if (card.getBalance() >= amount) {
            card.setBalance(card.getBalance() - amount);
            return "Payment processed successfully. Amount: " + amount;
        } else {
            return "Payment rejected";
        }
    }

    @Override
    public void sendNotification() {
        System.out.println("Notification: Card payment successfully processed");
    }
}
