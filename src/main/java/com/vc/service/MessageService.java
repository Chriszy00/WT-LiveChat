package com.vc.service;

import com.vc.entity.Message;
import com.vc.entity.User;
import com.vc.repository.MessageRepository;
import com.vc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    public Message createMessage(User sender, User receiver, String messageText) {

        // Create a new message
        Message message = new Message();
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setMessage(messageText);
        message.setDateTime(java.time.LocalDateTime.now().toString());

        // Save the message to the database
        return messageRepository.save(message);
    }

    public List<Message> getMessageHistory() {
        return messageRepository.findAll();
    }

    public List<Message> getMessagesBetweenSenderOrReceiver(Long loggedUser, Long userId) {
        return messageRepository.findMessagesBetweenSenderOrReceiver(loggedUser, userId);
    }

    public List<Message> getMessageHistoryByUser(Long userId) {
        // Assuming you have a method in your repository to find messages by sender or receiver ID
        return messageRepository.findMessagesBySenderOrReceiver(userId);
    }
}

