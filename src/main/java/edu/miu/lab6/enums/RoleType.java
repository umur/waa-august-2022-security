package edu.miu.lab6.enums;

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
