package com.dwee.backenddwee.Security;

public enum UserPermission {
    DOCTOR_READ("doctor:read"),
    DOCTOR_CREATE("doctor:create"),
    DOCTOR_UPDATE("doctor:update"),
    DOCTOR_DELETE("doctor:delete"),
    CHIEF_SERVICE_READ("chief_service:read"),
    CHIEF_SERVICE_CREATE("chief_service:create"),
    CHIEF_SERVICE_UPDATE("chief_service:update"),
    CHIEF_SERVICE_DELETE("chief_service:delete");

    private final String permission;

    UserPermission (String permission){
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }

}
