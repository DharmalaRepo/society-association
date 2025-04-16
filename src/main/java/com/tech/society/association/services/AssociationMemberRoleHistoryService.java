package com.tech.society.association.services;

import com.tech.society.association.models.AssociationMemberRoleHistory;
import java.util.List;

public interface AssociationMemberRoleHistoryService {
    AssociationMemberRoleHistory save(AssociationMemberRoleHistory history);
    List<AssociationMemberRoleHistory> findByMemberId(String memberId);

    int generateCustomId();
}