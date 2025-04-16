package com.tech.society.association.repositories;

import com.tech.society.association.models.AssociationMemberRoleHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface AssociationMemberRoleHistoryRepository extends MongoRepository<AssociationMemberRoleHistory, String> {
    List<AssociationMemberRoleHistory> findByMemberIdOrderByChangedOnDesc(String memberId);
    Optional<AssociationMemberRoleHistory> findTopByOrderByCustomIdDesc();

    // Custom query method to fetch the document with the highest customId
    AssociationMemberRoleHistory findFirstByOrderByCustomIdDesc();
}