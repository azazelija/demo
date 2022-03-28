package org.demo.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.demo.dto.RoleEnum;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    RoleEnum name;

    @OneToMany(mappedBy = "role")
    List<UserEntity> users;
}

