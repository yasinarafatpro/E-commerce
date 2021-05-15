package com.example.demo.security;


import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.demo.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    CUSTOMER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(CUSTOMER_READ,CUSTOMER_WRITE,PRODUCT_READ,PRODUCT_WRITE));//static import

    private final Set<ApplicationUserPermission> permissions;
    //constructor
    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }
}
