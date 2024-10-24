package co.edu.umanizales.payment_process.controllers;

import co.edu.umanizales.payment_process.models.Payment;
import co.edu.umanizales.payment_process.models.PayPalPayment;
import co.edu.umanizales.payment_process.models.CardPayment;
import co.edu.umanizales.payment_process.models.PayPalAccount;
import co.edu.umanizales.payment_process.models.Card;
import co.edu.umanizales.payment_process.services.PaymentService;
import co.edu.umanizales.payment_process.services.PayPalService;
import co.edu.umanizales.payment_process.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private CardService cardService;

    @Autowired
    private PayPalService payPalService;

    @PostMapping("/card")
    public String cardPaymentProcess(@RequestParam Long cardId, @RequestParam double amount) {
        Card card = cardService.getCard(cardId);

        if (card == null) {
            return "Card not found";
        }

        if (card.getBalance() >= amount) {
            double newBalance = card.getBalance() - amount;
            card.setBalance(newBalance);
            Payment payment = new CardPayment(amount, card);
            paymentService.paymentProcess(payment);
            return "Card payment successfully processed. New balance: " + card.getBalance() + " Amount: " + amount;
        } else {
            return "Insufficient balance";
        }
    }

    @PostMapping("/paypal")
    public String PayPalPaymentProcess(@RequestParam Long accountId, @RequestParam double amount) {
        PayPalAccount account = payPalService.getAccount(accountId);

        if (account == null) {
            return "Account not found";
        }

        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            Payment payment = new PayPalPayment(amount, account);
            paymentService.paymentProcess(payment);
            return "PayPal payment successfully processed. New balance: " + account.getBalance();
        } else {
            return "Insufficient balance";
        }
    }
}
