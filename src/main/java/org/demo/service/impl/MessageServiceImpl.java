package org.demo.service.impl;

import org.demo.dto.Message;
import org.demo.service.MessageService;
import org.demo.entity.MessageEntity;
import org.demo.mapper.MessageMapper;
import org.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    MessageRepository messageRepository;

    MessageMapper messageMapper;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository, MessageMapper messageMapper) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
    }

    @Override
    public Message getById(Long id) {
        MessageEntity messageEntity = messageRepository.getById(id);

        return messageMapper.entityToModel(messageEntity);
    }

    @Override
    public Message create(Message message) {
        MessageEntity messageEntity = messageMapper.modelToEntity(message);

        messageEntity = messageRepository.save(messageEntity);
        return messageMapper.entityToModel(messageEntity);
    }

    @Override
    public Message update(Message message) {
        MessageEntity messageEntity = messageMapper.modelToEntity(message);

        messageEntity = messageRepository.save(messageEntity);
        return messageMapper.entityToModel(messageEntity);
    }

    @Override
    public void deleteById(Long id) {
        messageRepository.deleteById(id);
    }
}
