package com.dwee.backenddwee.Models;

public enum ERole {
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_CHIEF_SERVICE("ROLE_CHIEF_SERVICE"),
    ROLE_DOCTOR("ROLE_DOCTOR"),
    ROLE_USER("ROLE_USER");
    private final String role;

    ERole(String role){
        this.role = role;
    }
    public String getROLE(){
        return this.role;
    }
}
