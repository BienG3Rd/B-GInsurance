package model;

import java.util.Date;

/**
 * Represents a payment made for a policy or claim.
 * Contains payment details such as ID, amount, date, and method.
 */
public class Payment {
    private String paymentId; // Unique payment identifier
    private double amount; // Payment amount
    private Date date; // Date of payment
    private String method; // Payment method (e.g., cash, card)

    /**
     * Constructs a Payment with specified details.
     * @param paymentId Unique payment ID
     * @param amount Payment amount
     * @param date Date of payment
     * @param method Payment method
     */
    public Payment(String paymentId, double amount, Date date, String method) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.date = date;
        this.method = method;
    }

    // Getters and setters for encapsulation
    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * Processes the payment.
     * Placeholder for payment processing logic.
     */
    public void processPayment() {
        // Payment processing logic here
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", method='" + method + '\'' +
                '}';
    }
}
