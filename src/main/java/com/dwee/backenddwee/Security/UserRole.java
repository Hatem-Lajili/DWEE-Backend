package com.dwee.backenddwee.Security;

import com.google.common.collect.Sets;
import java.util.Set;

import static com.dwee.backenddwee.Security.UserPermission.*;

public enum UserRole {
    DOCTOR(Sets.newHashSet()),
    CHIEF_SERVICE(Sets.newHashSet(DOCTOR_READ,
            DOCTOR_CREATE,
            DOCTOR_UPDATE,
            DOCTOR_DELETE));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }
}
