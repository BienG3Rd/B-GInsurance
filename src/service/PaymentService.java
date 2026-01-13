package service;

import model.Payment;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class to manage payments.
 * Provides methods to make payments and retrieve payment history.
 */
public class PaymentService {
    private List<Payment> payments = new ArrayList<>(); // List to store payments

    /**
     * Adds a payment and processes it.
     * @param payment Payment to make
     */
    public void makePayment(Payment payment) {
        payments.add(payment);
        payment.processPayment();
    }

    /**
     * Returns the list of all payments.
     * @return List of payments
     */
    public List<Payment> getPayments() {
        return payments;
    }
}
