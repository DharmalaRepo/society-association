// AssociationMemberService.java
package com.tech.society.association.services;

import com.tech.society.association.models.AssociationMember;
import java.util.List;

public interface AssociationMemberService {
    AssociationMember save(AssociationMember member);
    List<AssociationMember> findAll();
    AssociationMember findById(String id);
    void deleteById(String id);

    AssociationMember updateMember(String id, AssociationMember updatedMember);
}