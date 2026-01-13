package model;

/**
 * Represents a life insurance policy.
 * Extends the base Policy class with specific premium calculation.
 */
public class LifePolicy extends Policy {

    /**
     * Constructs a LifePolicy with specified details.
     * @param policyNumber Unique policy number
     * @param premium Premium amount
     * @param coverageAmount Coverage amount
     */
    public LifePolicy(String policyNumber, double premium, double coverageAmount) {
        super(policyNumber, "Life", premium, coverageAmount);
    }

    /**
     * Calculates the premium for life insurance.
     * Applies a 10% increase to the base premium.
     * @return Calculated premium
     */
    @Override
    public double calculatePremium() {
        // Example premium calculation for life insurance
        return getPremium() * 1.1; // 10% increase for life policies
    }

}
