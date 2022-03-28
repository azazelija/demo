package org.demo.repository;

import org.demo.dto.RoleEnum;
import org.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

//    @Query("select u from UserEntity u where u.role.name = :role")
    public Set<UserEntity> findByRoleName(RoleEnum roleEnum);

    @Query("select u from UserEntity u where u.name = :name")
    UserEntity findByName(String name);
}

