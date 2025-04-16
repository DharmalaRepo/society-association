package com.tech.society.association.repositories;

import com.tech.society.association.models.AssociationMeeting;
import com.tech.society.association.models.AssociationMember;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssociationMemberRepository extends MongoRepository<AssociationMember, String> {
    Optional<AssociationMember> findByCustomId(Long customId);
    List<AssociationMember> findByCustomIdIn(List<Long> customIds);
    void deleteByCustomId(Long customId);
    void deleteByCustomIdIn(List<Long> customIds);
}