package service;

import model.Claim;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class to manage claims.
 * Provides methods to file, approve, and retrieve claims.
 */
public class ClaimService {
    private List<Claim> claims = new ArrayList<>(); // List to store claims

    /**
     * Files a new claim.
     * @param claim Claim to file
     */
    public void fileClaim(Claim claim) {
        claims.add(claim);
    }

    /**
     * Approves a claim by its ID.
     * @param claimId ID of the claim to approve
     */
    public void approveClaim(String claimId) {
        for (Claim claim : claims) {
            if (claim.getClaimId().equals(claimId)) {
                claim.updateStatus("Approved");
                break;
            }
        }
    }

    /**
     * Retrieves a claim by its ID.
     * @param claimId ID of the claim
     * @return Claim object or null if not found
     */
    public Claim getClaim(String claimId) {
        for (Claim claim : claims) {
            if (claim.getClaimId().equals(claimId)) {
                return claim;
            }
        }
        return null;
    }

    /**
     * Returns a list of all claims.
     * @return List of claims
     */
    public List<Claim> getAllClaims() {
        return claims;
    }
}
