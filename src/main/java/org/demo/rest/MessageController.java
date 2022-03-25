package org.demo.rest;

import org.demo.dto.Message;
import org.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageController {

    MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable Long id) {
        Message message = messageService.getById(id);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Message> create(@RequestBody Message message) {
        Message createdMessage = messageService.create(message);

        return new ResponseEntity<>(createdMessage, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Message> update(@PathVariable Long id, @RequestBody Message message) {
        message.setId(id);
        Message updatedMessage = messageService.update(message);

        return new ResponseEntity<>(updatedMessage, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        messageService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
