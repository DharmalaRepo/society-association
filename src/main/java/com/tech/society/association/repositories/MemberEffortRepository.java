package com.tech.society.association.repositories;

import com.tech.society.association.models.MemberEffort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberEffortRepository extends MongoRepository<MemberEffort, String> {
    Optional<MemberEffort> findByCustomId(Long customId);
    List<MemberEffort> findByMemberId(String memberId);
    List<MemberEffort> findByTaskId(String taskId);
    List<MemberEffort> findByMeetingId(String meetingId);
    void deleteByCustomId(Long customId);
}