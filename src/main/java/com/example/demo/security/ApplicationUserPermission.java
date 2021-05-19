package com.example.demo.security;


public enum ApplicationUserPermission {
    CUSTOMER_READ("customer:read"),
    CUSTOMER_WRITE("customer:write"),
    PRODUCT_READ("product:read"),
    PRODUCT_WRITE("product:write");
    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
