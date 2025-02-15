package edu.rims.Fash_in.constant;

public enum WishlistStatus {
    ADDED("Added"),
    REMOVED("Removed"),
    ACTIVE("Active");

    private final String status;

    WishlistStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return status;
    }
}

