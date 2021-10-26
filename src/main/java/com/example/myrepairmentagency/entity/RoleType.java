package com.example.myrepairmentagency.entity;

import org.springframework.security.core.GrantedAuthority;

public enum RoleType implements GrantedAuthority {
    ADMIN,
    USER,
    MASTER;

    @Override
    public String getAuthority() {
        return name();
    }
}
