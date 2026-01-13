package model;

/**
 * Represents a car insurance policy.
 * Extends the base Policy class with specific premium calculation.
 */
public class CarPolicy extends Policy {

    /**
     * Constructs a CarPolicy with specified details.
     * @param policyNumber Unique policy number
     * @param premium Premium amount
     * @param coverageAmount Coverage amount
     */
    public CarPolicy(String policyNumber, double premium, double coverageAmount) {
        super(policyNumber, "Car", premium, coverageAmount);
    }

    /**
     * Calculates the premium for car insurance.
     * Applies a 20% increase to the base premium.
     * @return Calculated premium
     */
    @Override
    public double calculatePremium() {
        // Example premium calculation for car insurance
        return getPremium() * 1.2; // 20% increase for car policies
    }

}
