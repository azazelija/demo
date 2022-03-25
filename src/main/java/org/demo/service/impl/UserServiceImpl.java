package org.demo.service.impl;

import org.demo.dto.User;
import org.demo.dto.User;
import org.demo.entity.UserEntity;
import org.demo.service.UserService;
import org.demo.mapper.UserMapper;
import org.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    UserMapper userMapper;

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public User getById(Long id) {
        UserEntity userEntity = userRepository.getById(id);

        return userMapper.entityToModel(userEntity);
    }

    @Override
    public Set<User> getByRole(String role) {
        Set<UserEntity> userEntitySet = userRepository.findByRoleName(role.toUpperCase());

        Set<User> users = userEntitySet.stream()
                .map((e) -> userMapper.entityToModel(e))
                .collect(Collectors.toSet());

        return users;
    }

    @Override
    public User create(User message) {
        UserEntity userEntity = userMapper.modelToEntity(message);

        userEntity = userRepository.save(userEntity);
        return userMapper.entityToModel(userEntity);
    }

    @Override
    public User update(User message) {
        UserEntity userEntity = userMapper.modelToEntity(message);

        userEntity = userRepository.save(userEntity);
        return userMapper.entityToModel(userEntity);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
