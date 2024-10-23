package co.edu.umanizales.payment_process.controllers;

import co.edu.umanizales.payment_process.models.PayPalAccount;
import co.edu.umanizales.payment_process.services.PayPalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paypal")
public class PayPalController {

    @Autowired
    private PayPalService payPalService;

    @PostMapping
    public PayPalAccount createAccount(@RequestBody PayPalAccount account) {
        return payPalService.createAccount(account);
    }

    @GetMapping("/{id}")
    public PayPalAccount getAccount(@PathVariable Long id) {
        return payPalService.getAccount(id);
    }

    @GetMapping
    public List<PayPalAccount> getAccounts() {
        return payPalService.getAccounts();
    }

    @DeleteMapping("/{id}")
    public void removeAccount(@PathVariable Long id) {
        payPalService.removeAccount(id);
    }
}
