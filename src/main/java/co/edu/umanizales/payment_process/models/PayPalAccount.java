package co.edu.umanizales.payment_process.models;

public class PayPalAccount {

    private Long id;
    private String email;
    private double balance;

    public PayPalAccount(Long id, String email, double balance) {
        this.id = id;
        this.email = email;
        this.balance = balance;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
