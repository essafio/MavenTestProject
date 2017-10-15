package com.config;

import com.beans.User;

import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

class MySecurityContext implements SecurityContext {

    private User user;

    public MySecurityContext(User user) {
        this.user = user;
    }

    @Override
    public Principal getUserPrincipal() {
        return new Principal() {
            @Override
            public String getName() {
                return user.getUsername();
            }
        };
    }

    @Override
    public boolean isUserInRole(String role) {
        return role.equals(user.getClass().getSimpleName().toLowerCase());
    }

    @Override
    public boolean isSecure() { return true; }

    @Override
    public String getAuthenticationScheme() {
        return "Basic";
    }

}