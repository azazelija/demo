package org.demo.security;


import lombok.Getter;
import org.demo.entity.UserEntity;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Getter
public class SecurityUser implements UserDetails {

    private final String username;
    private final String password;
    private final Collection<? extends GrantedAuthority> simpleGrantedAuthorities;

    public SecurityUser(String username, String password, Collection<? extends GrantedAuthority> simpleGrantedAuthorities) {
        this.username = username;
        this.password = password;
        this.simpleGrantedAuthorities = simpleGrantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return simpleGrantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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

    public static SecurityUser userEntityToSecurityUser(UserEntity userEntity) {
        SecurityRole securityRole = SecurityRole.roleEntityToSecurityRole(userEntity.getRole());
        SecurityUser securityUser = new SecurityUser(userEntity.getName(), userEntity.getPassword(), Collections.singletonList(securityRole));

        return securityUser;
    }
}
