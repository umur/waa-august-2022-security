package com.example.lab5sec.enums;

public enum RoleType {

    ADMIN("ADMIN"),
    USER("CLIENT");
    private final String role;

    RoleType(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return role;
    }
}
