package org.demo.service;

import org.demo.dto.Message;
import org.demo.dto.Role;

public interface RoleService {

    public Role getById(Long id);

    public Role create(Role role);

    public Role update(Role role);

    public void deleteById(Long id);
}
