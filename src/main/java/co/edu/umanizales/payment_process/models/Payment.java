package co.edu.umanizales.payment_process.models;

public abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract String paymentProcess();

    public double getMonto() {
        return amount;
    }
}
