package com.tech.society.association.repositories;

import com.tech.society.association.models.AssociationMeeting;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssociationMeetingRepository extends MongoRepository<AssociationMeeting, String> {
    Optional<AssociationMeeting> findByCustomId(Long customId);
    List<AssociationMeeting> findByCustomIdIn(List<Long> customIds);
    void deleteByCustomId(Long customId);
    void deleteByCustomIdIn(List<Long> customIds);
}