package com.tech.society.association.repositories;

import com.tech.society.association.models.AssociationMeeting;
import com.tech.society.association.models.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationRepository extends MongoRepository<Notification, String> {
    Optional<Notification> findByCustomId(Long customId);
    List<Notification> findByRecipientIdsContaining(String memberId);
    void deleteByCustomId(Long customId);
}