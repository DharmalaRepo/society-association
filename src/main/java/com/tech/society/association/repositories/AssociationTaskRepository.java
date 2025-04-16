package com.tech.society.association.repositories;

import com.tech.society.association.models.AssociationMeeting;
import com.tech.society.association.models.AssociationTask;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssociationTaskRepository extends MongoRepository<AssociationTask, String> {
    Optional<AssociationTask> findByCustomId(Long customId);
    List<AssociationTask> findByAssignedToId(String memberId);
    List<AssociationTask> findByStatus(String status);
    void deleteByCustomId(Long customId);
}