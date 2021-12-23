package ir.sharif.security.model;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority {
    DOCTOR, PATIENT, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
