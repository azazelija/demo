package org.demo.service;

import org.demo.dto.Message;
import org.demo.dto.User;

import java.util.Set;

public interface UserService {

    public User getById(Long id);

    public Set<User> getByRole(String role);

    public User create(User user);

    public User update(User user);

    public void deleteById(Long id);
}
