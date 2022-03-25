package org.demo.mapper;

import org.demo.dto.Role;
import org.demo.entity.RoleEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = UserMapper.class)
public interface RoleMapper extends EntityMapper<RoleEntity, Role> {
}

