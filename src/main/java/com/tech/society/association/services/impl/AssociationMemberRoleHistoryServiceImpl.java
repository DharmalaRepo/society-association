package com.tech.society.association.services.impl;

import com.tech.society.association.models.AssociationMemberRoleHistory;
import com.tech.society.association.repositories.AssociationMemberRoleHistoryRepository;
import com.tech.society.association.services.AssociationMemberRoleHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssociationMemberRoleHistoryServiceImpl implements AssociationMemberRoleHistoryService {

    @Autowired
    private AssociationMemberRoleHistoryRepository repository;

    @Override
    public AssociationMemberRoleHistory save(AssociationMemberRoleHistory history) {
        return repository.save(history);
    }

    @Override
    public List<AssociationMemberRoleHistory> findByMemberId(String memberId) {
        return repository.findByMemberIdOrderByChangedOnDesc(memberId);

    }

    public int generateCustomId() {
        // Fetch the document with the highest customId
        AssociationMemberRoleHistory latestRoleHistory = repository
                .findFirstByOrderByCustomIdDesc();  // Returns the first document sorted by customId in descending order

        if (latestRoleHistory == null) {
            return 1;  // If no records exist, start from 1
        } else {
            return latestRoleHistory.getCustomId() + 1;  // Increment the customId
        }
    }

}