package org.demo.service.impl;

import org.demo.dto.User;
import org.demo.dto.RoleEnum;
import org.demo.entity.UserEntity;
import org.demo.service.UserService;
import org.demo.mapper.UserMapper;
import org.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    UserMapper userMapper;

    UserRepository userRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User getById(Long id) {
        UserEntity userEntity = userRepository.getById(id);

        return userMapper.entityToModel(userEntity);
    }

    @Override
    public Set<User> getByRoleUser() {
        Set<UserEntity> userEntitySet = userRepository.findByRoleName(RoleEnum.USER);

        Set<User> users = userEntitySet.stream()
                .map((e) -> userMapper.entityToModel(e))
                .collect(Collectors.toSet());

        return users;
    }

    @Override
    public Set<User> getByRoleAdmin() {
        Set<UserEntity> userEntitySet = userRepository.findByRoleName(RoleEnum.ADMIN);

        Set<User> users = userEntitySet.stream()
                .map((e) -> userMapper.entityToModel(e))
                .collect(Collectors.toSet());

        return users;
    }

    @Override
    public User create(User user) {
        if (userRepository.findByName(user.getName()) != null)
            throw  new IllegalArgumentException();

        UserEntity userEntity = userMapper.modelToEntity(user);

        userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
        userEntity = userRepository.save(userEntity);
        return userMapper.entityToModel(userEntity);
    }

    @Override
    public User update(User user) {
        UserEntity userEntity = userMapper.modelToEntity(user);

        userEntity = userRepository.save(userEntity);
        return userMapper.entityToModel(userEntity);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
