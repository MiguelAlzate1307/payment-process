package co.edu.umanizales.payment_process.services;

import co.edu.umanizales.payment_process.models.PayPalAccount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PayPalService {

    private List<PayPalAccount> accounts = new ArrayList<>();
    private Long currentId = 1L;

    public PayPalAccount createCard(PayPalAccount account) {
        account.setId(currentId++);
        accounts.add(account);
        return account;
    }

    public PayPalAccount getAccount(Long id) {
        return accounts.stream()
                .filter(account -> account.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<PayPalAccount> getAccounts() {
        return accounts;
    }

    public void removeAccount(Long id) {
        accounts.removeIf(account -> account.getId().equals(id));
    }
}
