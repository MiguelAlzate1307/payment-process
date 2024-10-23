package co.edu.umanizales.payment_process.controllers;

import co.edu.umanizales.payment_process.models.Payment;
import co.edu.umanizales.payment_process.models.PayPalPayment;
import co.edu.umanizales.payment_process.models.CardPayment;
import co.edu.umanizales.payment_process.models.PayPalAccount;
import co.edu.umanizales.payment_process.models.Card;
import co.edu.umanizales.payment_process.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/card")
    public void cardPaymentProcess(@RequestBody Card card, @RequestParam double amount) {
        Payment payment = new CardPayment(amount, card);
        paymentService.paymentProcess(payment);
    }

    @PostMapping("/paypal")
    public void PayPalPaymentProcess(@RequestBody PayPalAccount account, @RequestParam double amount) {
        Payment payment = new PayPalPayment(amount, account);
        paymentService.paymentProcess(payment);
    }
}
