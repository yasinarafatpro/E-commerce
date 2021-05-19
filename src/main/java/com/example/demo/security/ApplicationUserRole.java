package com.example.demo.security;


import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.demo.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    CUSTOMER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(CUSTOMER_READ,CUSTOMER_WRITE,PRODUCT_READ,PRODUCT_WRITE)),//static import
    ADMINTRAINEE(Sets.newHashSet(CUSTOMER_READ,PRODUCT_READ));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {

        this.permissions = permissions;
    }
    public Set<ApplicationUserPermission>getPermissions(){

        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
       Set<SimpleGrantedAuthority> permissions= getPermissions().stream()
                .map(permission->new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
       permissions.add(new SimpleGrantedAuthority("ROLE_"+ this.name()));
       return permissions;
    }
}

