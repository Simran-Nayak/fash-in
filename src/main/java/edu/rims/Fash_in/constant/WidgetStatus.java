package edu.rims.Fash_in.constant;


public enum WidgetStatus {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    PENDING("Pending");

    private final String status;

    WidgetStatus(String status) {
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
