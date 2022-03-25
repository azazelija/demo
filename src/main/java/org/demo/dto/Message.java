package org.demo.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.OffsetDateTime;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Message {

    Long id;

    String text;

    OffsetDateTime messageTime;
}
