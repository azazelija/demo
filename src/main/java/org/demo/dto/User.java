package org.demo.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class User {

    Long id;

    Role role;

    String name;

    String password;

    String email;

    String phone;
}

