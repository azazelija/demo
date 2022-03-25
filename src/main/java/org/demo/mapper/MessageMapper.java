package org.demo.mapper;

import org.demo.dto.Message;
import org.demo.entity.MessageEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MessageMapper extends EntityMapper<MessageEntity, Message> {
}
