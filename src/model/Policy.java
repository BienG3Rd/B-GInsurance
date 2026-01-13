package model;

/**
 * Represents an insurance policy.
 * Contains policy details such as number, type, premium, and coverage amount.
 */
public class Policy {
    private String policyNumber; // Unique policy number
    private String type; // Type of policy (e.g., life, car)
    private double premium; // Premium amount
    private double coverageAmount; // Coverage amount

    /**
     * Constructs a Policy with specified details.
     * @param policyNumber Unique policy number
     * @param type Type of policy
     * @param premium Premium amount
     * @param coverageAmount Coverage amount
     */
    public Policy(String policyNumber, String type, double premium, double coverageAmount) {
        this.policyNumber = policyNumber;
        this.type = type;
        this.premium = premium;
        this.coverageAmount = coverageAmount;
    }

    // Getters and setters for encapsulation
    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public double getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(double coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    /**
     * Calculates the premium for the policy.
     * Can be overridden by subclasses for specific calculations.
     * @return Calculated premium
     */
    public double calculatePremium() {
        // Basic premium calculation logic (can be overridden by subclasses)
        return premium;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", type='" + type + '\'' +
                ", premium=" + premium +
                ", coverageAmount=" + coverageAmount +
                '}';
    }
}
