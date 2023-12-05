package com.vc.controller;

import com.vc.entity.Message;
import com.vc.entity.User;
import com.vc.repository.UserRepository;
import com.vc.service.MessageService;
import com.vc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/message")
public class MessageController {

    private final MessageService messageService;

    private final UserService userService;

    @Autowired
    public MessageController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(
            @RequestParam Long senderId,
            @RequestParam Long receiverId,
            @RequestParam String messageText) {

        try {
            User sender = userRepository.findById(senderId).orElseThrow(() -> new EntityNotFoundException("Sender not found"));
            User receiver = userRepository.findById(receiverId).orElseThrow(() -> new EntityNotFoundException("Receiver not found"));

            Message createdMessage = messageService.createMessage(sender, receiver, messageText);
            return ResponseEntity.status(HttpStatus.CREATED).body("Message sent successfully. Message ID: " + createdMessage.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending message: " + e.getMessage());
        }
    }

    @GetMapping("/history")
    public ResponseEntity<List<Message>> getMessageHistoryByUser(@RequestParam Long userId) {
        try {
            List<Message> messageHistory = messageService.getMessageHistoryByUser(userId);
            return ResponseEntity.ok(messageHistory);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/conversation")
    public ResponseEntity<List<Message>> getConversation(@RequestParam Long userId, @RequestParam Long receiverId) {
        try {
            List<Message> conversation = messageService.getMessagesBetweenSenderOrReceiver(userId, receiverId);
            return ResponseEntity.ok(conversation);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = userService.fetchAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
