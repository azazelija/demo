package org.demo.service.impl;

import org.demo.dto.Role;
import org.demo.dto.Role;
import org.demo.entity.RoleEntity;
import org.demo.service.RoleService;
import org.demo.mapper.RoleMapper;
import org.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    RoleMapper roleMapper;

    RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleMapper roleMapper, RoleRepository roleRepository) {
        this.roleMapper = roleMapper;
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getById(Long id) {
        RoleEntity roleEntity = roleRepository.getById(id);

        return roleMapper.entityToModel(roleEntity);
    }

    @Override
    public Role create(Role message) {
        RoleEntity roleEntity = roleMapper.modelToEntity(message);

        roleEntity = roleRepository.save(roleEntity);
        return roleMapper.entityToModel(roleEntity);
    }

    @Override
    public Role update(Role message) {
        RoleEntity roleEntity = roleMapper.modelToEntity(message);

        roleEntity = roleRepository.save(roleEntity);
        return roleMapper.entityToModel(roleEntity);
    }

    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }
}
