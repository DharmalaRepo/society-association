package com.tech.society.association.repositories;

import com.tech.society.association.models.MinutesOfMeeting;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MinutesOfMeetingRepository extends MongoRepository<MinutesOfMeeting, String> {
    Optional<MinutesOfMeeting> findByCustomId(Long customId);
    List<MinutesOfMeeting> findByMeetingId(String meetingId);
    void deleteByCustomId(Long customId);
}