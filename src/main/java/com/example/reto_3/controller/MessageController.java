package com.example.reto_3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.reto_3.entities.Message;
import com.example.reto_3.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/Message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getMessages(){
        return messageService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int messageId) {
        return messageService.getMessage(messageId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody  Message message){
        return messageService.save(message);
    }
}
