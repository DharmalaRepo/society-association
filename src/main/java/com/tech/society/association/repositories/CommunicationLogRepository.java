package com.tech.society.association.repositories;

import com.tech.society.association.models.CommunicationLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommunicationLogRepository extends MongoRepository<CommunicationLog, String> {
    Optional<CommunicationLog> findByCustomId(Long customId);
    List<CommunicationLog> findByMemberId(String memberId);
    void deleteByCustomId(Long customId);
}