package org.demo.security;

import org.demo.entity.UserEntity;
import org.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserService implements UserDetailsService {

    UserRepository userRepository;

    @Autowired
    public SecurityUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return SecurityUser.userEntityToSecurityUser(user);
    }
}
