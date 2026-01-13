package service;

import model.Policy;
import model.LifePolicy;
import model.CarPolicy;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

/**
 * Service class to manage insurance policies.
 * Provides methods to create, add, update, delete, and retrieve policies.
 */
public class PolicyService {
    private Map<String, Policy> policyMap = new HashMap<>(); // Map to store policies by policy number

    /**
     * Adds a policy to the service.
     * @param policy Policy to add
     */
    public void addPolicy(Policy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
    }

    /**
     * Retrieves a policy by its policy number.
     * @param policyNumber Policy number to search
     * @return Policy object or null if not found
     */
    public Policy getPolicy(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    /**
     * Updates an existing policy.
     * @param policy Policy object with updated details
     */
    public void updatePolicy(Policy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
    }

    /**
     * Deletes a policy by its policy number.
     * @param policyNumber Policy number to delete
     */
    public void deletePolicy(String policyNumber) {
        policyMap.remove(policyNumber);
    }

    /**
     * Calculates the premium for a given policy number.
     * @param policyNumber Policy number
     * @return Calculated premium or 0 if policy not found
     */
    public double calculatePremium(String policyNumber) {
        Policy policy = policyMap.get(policyNumber);
        if (policy != null) {
            return policy.calculatePremium();
        }
        return 0;
    }

    /**
     * Factory method to create a policy based on type.
     * @param type Type of policy (life, car, other)
     * @param policyNumber Policy number
     * @param premium Premium amount
     * @param coverageAmount Coverage amount
     * @return Created Policy object
     */
    public Policy createPolicy(String type, String policyNumber, double premium, double coverageAmount) {
        switch (type.toLowerCase()) {
            case "life":
                return new LifePolicy(policyNumber, premium, coverageAmount);
            case "car":
                return new CarPolicy(policyNumber, premium, coverageAmount);
            default:
                return new Policy(policyNumber, type, premium, coverageAmount);
        }
    }

    /**
     * Returns a collection of all policies.
     * @return Collection of policies
     */
    public Collection<Policy> getAllPolicies() {
        return policyMap.values();
    }
}
