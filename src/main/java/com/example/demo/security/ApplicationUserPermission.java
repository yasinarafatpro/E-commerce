package com.example.demo.security;


public enum ApplicationUserPermission {
    CUSTOMER_READ("customer:read"),
    CUSTOMER_WRITE("customer_write"),
    PRODUCT_READ("product_read"),
    PRODUCT_WRITE("product_write");
    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
