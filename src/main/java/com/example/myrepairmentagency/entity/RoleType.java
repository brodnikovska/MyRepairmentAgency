package com.example.myrepairmentagency.entity;

public enum RoleType {
    ROLE_ADMIN("admin"),
    ROLE_USER("user"),
    ROLE_MASTER("master");

    private String name;

    RoleType(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
