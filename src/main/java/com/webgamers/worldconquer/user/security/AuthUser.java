package com.webgamers.worldconquer.user.security;

import com.webgamers.worldconquer.user.model.User;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Getter
public class AuthUser implements UserDetails {
    private final Long id;
    private final String email;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;
    private final Map<String, Object> attributes;

    @Builder
    public AuthUser(final Long id,
                    final String email,
                    final String password,
                    final Collection<? extends GrantedAuthority> authorities,
                    final Map<String, Object> attributes) {

        this.id = id;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.attributes = attributes;
    }

    public static AuthUser create(final User user) {
        List<GrantedAuthority> authorities =
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));

        return AuthUser.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }

    public static AuthUser create(final User user, final Map<String, Object> attributes) {
        return AuthUser.create(user)
                .withAttribute(attributes);
    }

    private AuthUser withAttribute(final Map<String, Object> attributes) {
        return AuthUser.builder()
                .id(id)
                .email(email)
                .password(password)
                .authorities(authorities)
                .attributes(attributes)
                .build();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

}
