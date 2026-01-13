package model;

import java.util.Date;

/**
 * Represents a claim filed against a policy.
 * Contains claim details such as ID, date, status, and amount.
 */
public class Claim {
    private String claimId; // Unique claim identifier
    private Date date; // Date the claim was filed
    private String status; // Status of the claim (e.g., filed, approved)
    private double amount; // Amount claimed

    /**
     * Constructs a Claim with specified details.
     * @param claimId Unique claim ID
     * @param date Date of claim
     * @param status Status of claim
     * @param amount Claimed amount
     */
    public Claim(String claimId, Date date, String status, double amount) {
        this.claimId = claimId;
        this.date = date;
        this.status = status;
        this.amount = amount;
    }

    // Getters and setters for encapsulation
    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Updates the status of the claim.
     * @param newStatus New status to set
     */
    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "claimId='" + claimId + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", amount=" + amount +
                '}';
    }
}
