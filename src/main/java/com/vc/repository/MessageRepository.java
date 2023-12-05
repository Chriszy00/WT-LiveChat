package com.vc.repository;

import com.vc.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("SELECT m FROM Message m WHERE m.sender.id = :userId OR m.receiver.id = :userId")
    List<Message> findMessagesBySenderOrReceiver(Long userId);

    @Query("SELECT m FROM Message m WHERE m.sender.id = :loggedUser AND m.receiver.id = :userId OR m.sender.id = :userId AND m.receiver.id = :loggedUser ORDER BY m.dateTime ASC")
    List<Message> findMessagesBetweenSenderOrReceiver(Long loggedUser, Long userId);


}
