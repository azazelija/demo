package org.demo.service;

import org.demo.dto.Message;

public interface MessageService {

    public Message getById(Long id);

    public Message create(Message message);

    public Message update(Message message);

    public void deleteById(Long id);
}
