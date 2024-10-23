package co.edu.umanizales.payment_process.services;

import org.springframework.stereotype.Service;

import co.edu.umanizales.payment_process.models.Notificable;
import co.edu.umanizales.payment_process.models.Payment;

@Service
public class PaymentService {
    public void paymentProcess(Payment payment) {
        payment.paymentProcess();
        if (payment instanceof Notificable) {
            ((Notificable) payment).sendNotification();
        }
    }
}
