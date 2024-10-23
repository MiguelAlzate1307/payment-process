package co.edu.umanizales.payment_process.models;

public class Card {
    
    private Long id;
    private String cardNumber;
    private double balance;

    public Card(Long id, String cardNumber, double balance) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
