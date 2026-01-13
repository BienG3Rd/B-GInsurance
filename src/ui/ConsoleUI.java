package ui;

import model.*;
import service.*;

import java.util.Scanner;
import java.util.Date;

/**
 * Console-based user interface for the Insurance Management System.
 */
public class ConsoleUI {
    // Scanner object for reading user input from the console
    private static Scanner scanner = new Scanner(System.in);
    
    // Service objects to manage policies, claims, and payments
    private static PolicyService policyService = new PolicyService();
    private static ClaimService claimService = new ClaimService();
    private static PaymentService paymentService = new PaymentService();

    /**
     * Main entry point of the application.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        boolean exit = false;
        // Main loop to display menu and process user choices until exit
        while (!exit) {
            printMenu(); // Display the main menu options
            int choice = getChoice(); // Get validated user choice
            switch (choice) {
                case 1:
                    registerCustomer(); // Register a new customer
                    break;
                case 2:
                    createPolicy(); // Create a new insurance policy
                    break;
                case 3:
                    fileClaim(); // File a new claim
                    break;
                case 4:
                    makePayment(); // Make a payment
                    break;
                case 5:
                    viewDetails(); // View all policies, claims, and payments
                    break;
                case 6:
                    exit = true; // Exit the application
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        System.out.println("Thank you for using the Insurance Management System.");
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("\n=== Insurance Management System ===");
        System.out.println("1. Register Customer");
        System.out.println("2. Create Policy");
        System.out.println("3. File Claim");
        System.out.println("4. Make Payment");
        System.out.println("5. View Details");
        System.out.println("6. Exit");
        System.out.print("Select an option (1-6): ");
    }

    /**
     * Reads and validates the user's menu choice input.
     * 
     * @return The validated user choice.
     */
    private static int getChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            scanner.next(); // Discard invalid input
            System.out.print("Select an option (1-6): ");
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        return choice;
    }

    /**
     * Handles the registration of a new customer.
     */
    private static void registerCustomer() {
        System.out.println("\n-- Register Customer --");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Contact Info: ");
        String contactInfo = scanner.nextLine();

        Customer customer = new Customer(name, id, contactInfo);
        // Confirmation message showing registered customer's name and ID
        System.out.println("Customer registered: " + customer.getName() + " (ID: " + customer.getId() + ")");
    }

    /**
     * Handles the creation of a new insurance policy.
     */
    private static void createPolicy() {
        System.out.println("\n-- Create Policy --");
        System.out.print("Policy Type (life/car/other): ");
        String type = scanner.nextLine().trim().toLowerCase();
        System.out.print("Policy Number: ");
        String policyNumber = scanner.nextLine();
        // Get positive double values for premium and coverage amount
        double premium = getPositiveDouble("Premium: ");
        double coverageAmount = getPositiveDouble("Coverage Amount: ");

        Policy policy = policyService.createPolicy(type, policyNumber, premium, coverageAmount);
        policyService.addPolicy(policy);
        // Confirmation message showing created policy number and type
        System.out.println("Policy created: " + policy.getPolicyNumber() + " (Type: " + policy.getType() + ")");
    }

    /**
     * Handles filing a new claim.
     */
    private static void fileClaim() {
        System.out.println("\n-- File Claim --");
        System.out.print("Claim ID: ");
        String claimId = scanner.nextLine();
        System.out.print("Claim Date (yyyy-mm-dd): ");
        String dateStr = scanner.nextLine();
        System.out.print("Claim Status: ");
        String status = scanner.nextLine();
        // Get positive double value for claim amount
        double amount = getPositiveDouble("Claim Amount: ");

        Date date;
        try {
            // Parse the date string into a Date object
            date = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (Exception e) {
            // Handle invalid date format input
            System.out.println("Invalid date format. Claim not filed.");
            return;
        }

        Claim claim = new Claim(claimId, date, status, amount);
        claimService.fileClaim(claim);
        // Confirmation message showing claim ID and status
        System.out.println("Claim filed: " + claim.getClaimId() + " (Status: " + claim.getStatus() + ")");
    }

    /**
     * Handles making a payment.
     */
    private static void makePayment() {
        System.out.println("\n-- Make Payment --");
        System.out.print("Payment ID: ");
        String paymentId = scanner.nextLine();
        // Get positive double value for payment amount
        double amount = getPositiveDouble("Payment Amount: ");
        System.out.print("Payment Date (yyyy-mm-dd): ");
        String dateStr = scanner.nextLine();
        System.out.print("Payment Method: ");
        String method = scanner.nextLine();

        Date date;
        try {
            // Parse the date string into a Date object
            date = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (Exception e) {
            // Handle invalid date format input
            System.out.println("Invalid date format. Payment not made.");
            return;
        }

        Payment payment = new Payment(paymentId, amount, date, method);
        paymentService.makePayment(payment);
        // Confirmation message showing payment ID and amount
        System.out.println("Payment made: " + payment.getPaymentId() + " (Amount: " + payment.getAmount() + ")");
    }

    /**
     * Displays all policies, claims, and payments stored in the system.
     */
    private static void viewDetails() {
        System.out.println("\n-- Policies --");
        for (Policy policy : policyService.getAllPolicies()) {
            System.out.println(policy.getPolicyNumber() + ": Type=" + policy.getType() + ", Premium=" + policy.getPremium() + ", Coverage=" + policy.getCoverageAmount());
        }

        System.out.println("\n-- Claims --");
        for (Claim claim : claimService.getAllClaims()) {
            System.out.println(claim.getClaimId() + ": Status=" + claim.getStatus() + ", Amount=" + claim.getAmount());
        }

        System.out.println("\n-- Payments --");
        for (Payment payment : paymentService.getPayments()) {
            System.out.println(payment.getPaymentId() + ": Amount=" + payment.getAmount() + ", Method=" + payment.getMethod());
        }
    }

    /**
     * Utility method to get a positive double value from user input with validation.
     * 
     * @param prompt The prompt to display to the user.
     * @return The validated positive double value.
     */
    private static double getPositiveDouble(String prompt) {
        double value = -1;
        while (value <= 0) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value <= 0) {
                    System.out.println("Value must be positive.");
                }
            } else {
                System.out.println("Please enter a valid number.");
                scanner.next(); // Discard invalid input
            }
        }
        scanner.nextLine(); // Consume newline character
        return value;
    }
}
