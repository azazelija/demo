package org.demo.mapper;

import org.demo.dto.User;
import org.demo.entity.UserEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper extends EntityMapper<UserEntity, User> {

    @Mapping(target = "role.users", ignore = true)
    User entityToModel(UserEntity entity);

    UserEntity modelToEntity(User model);
}

