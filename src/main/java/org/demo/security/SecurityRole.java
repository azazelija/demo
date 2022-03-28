package org.demo.security;

import lombok.Setter;
import org.demo.dto.RoleEnum;
import org.demo.entity.RoleEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Set;

//@Component
//@Setter
public class SecurityRole implements GrantedAuthority  {

    private final RoleEnum role;

    public SecurityRole(RoleEnum role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role.getRole();
    }

    public static SecurityRole roleEntityToSecurityRole(RoleEntity roleEntity) {
        SecurityRole securityRole = new SecurityRole(roleEntity.getName());
//        SecurityRole securityRole = new SecurityRole();
//        securityRole.setRole(roleEntity.getName());

        return securityRole;
    }
}
