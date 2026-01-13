package model;

import java.util.ArrayList;

/**
 * Represents a customer in the insurance system.
 * Contains personal details and a list of policies owned by the customer.
 */
public class Customer {
    private String name; // Customer's full name
    private String id; // Unique identifier for the customer
    private String contactInfo; // Contact information (phone/email)
    private ArrayList<Policy> policies; // List of policies owned by the customer

    /**
     * Constructs a new Customer with specified details.
     * @param name Customer's name
     * @param id Customer's unique ID
     * @param contactInfo Customer's contact details
     */
    public Customer(String name, String id, String contactInfo) {
        this.name = name;
        this.id = id;
        this.contactInfo = contactInfo;
        this.policies = new ArrayList<>();
    }

    // Getters and setters for encapsulation
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public ArrayList<Policy> getPolicies() {
        return policies;
    }

    /**
     * Adds a policy to the customer's list of policies.
     * @param policy The policy to add
     */
    public void addPolicy(Policy policy) {
        this.policies.add(policy);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", policies=" + policies +
                '}';
    }
}
