package com.tech.society.association.services;

import com.tech.society.association.models.MemberEffort;
import java.util.List;

public interface MemberEffortService {
    MemberEffort save(MemberEffort effort);
    List<MemberEffort> findAll();
    MemberEffort findById(String id);
    void deleteById(String id);
}