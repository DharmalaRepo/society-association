// AssociationMemberServiceImpl.java
package com.tech.society.association.services.impl;

import com.tech.society.association.models.AssociationMember;
import com.tech.society.association.models.AssociationMemberRoleHistory;
import com.tech.society.association.repositories.AssociationMemberRepository;
import com.tech.society.association.repositories.AssociationMemberRoleHistoryRepository;
import com.tech.society.association.services.AssociationMemberRoleHistoryService;
import com.tech.society.association.services.AssociationMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AssociationMemberServiceImpl implements AssociationMemberService {

    @Autowired
    private AssociationMemberRepository repository;

    @Autowired
    private AssociationMemberRoleHistoryRepository roleHistoryRepository;

    @Autowired
    private AssociationMemberRoleHistoryService associationMemberRoleHistoryService;


    @Override
    public AssociationMember save(AssociationMember member) {
        return repository.save(member);
    }

    @Override
    public List<AssociationMember> findAll() {
        return repository.findAll();
    }

    @Override
    public AssociationMember findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public AssociationMember updateMember(String id, AssociationMember updatedMember) {
        Optional<AssociationMember> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("Member not found with id: " + id);
        }

        AssociationMember existing = optional.get();
        boolean roleChanged = !existing.getRole().equals(updatedMember.getRole());

        existing.setName(updatedMember.getName());
        existing.setPhone(updatedMember.getPhone());
        existing.setEmail(updatedMember.getEmail());
        existing.setModifiedBy(updatedMember.getModifiedBy());
        existing.setModifiedDate(new Date());
        existing.setActive(updatedMember.getActive());

        // Check for role change
        if (roleChanged) {
            existing.setRole(updatedMember.getRole());

            // Save role change history
            AssociationMemberRoleHistory history = new AssociationMemberRoleHistory();
            history.setCustomId(associationMemberRoleHistoryService.generateCustomId());
            history.setMemberId(id);
            history.setPreviousRole(existing.getRole()); // Previous value
            history.setNewRole(updatedMember.getRole()); // Updated value
            history.setChangeReason("Updated via member update"); // Or pass reason
            history.setChangedBy(updatedMember.getModifiedBy());
            history.setChangedOn(new Date());
            history.setIs_active(1);
            roleHistoryRepository.save(history);
        }

        return repository.save(existing);
    }
}