package edu.rims.Fash_in.constant;

public enum OrderItemStatus {

    PENDING("PENDING"),
    SHIPPED("SHIPPED"),
    DELIVERED("DELIVERED"),
    CANCELLED("CANCELLED");

    private final String statusName;

    OrderItemStatus(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }

    @Override
    public String toString() {
        return statusName;
    }
}

