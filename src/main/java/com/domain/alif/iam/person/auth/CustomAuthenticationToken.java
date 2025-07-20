package com.domain.alif.iam.person.auth;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

public final class CustomAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = 560L;
    private final Object principal;
    private final Object credentials;

    public CustomAuthenticationToken(Object principal, Object credentials) {
        super((Collection<? extends GrantedAuthority>) null);
        this.principal = principal;
        this.credentials = credentials;
        this.setAuthenticated(false);
    }

    public CustomAuthenticationToken(Object principal, Object credentials,
            Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        this.setAuthenticated(true);

    }

    @Override
    public Object getCredentials() {

        return this.credentials;
    }

    @Override
    public Object getPrincipal() {

        return this.principal;

    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) {
        try {
            Assert.isTrue(!isAuthenticated,
                    "Cannot set this token to trusted - use constructor which takes a Granted Authority");
            super.setAuthenticated(false);

        } catch (IllegalArgumentException e) {
        }
    }

}
