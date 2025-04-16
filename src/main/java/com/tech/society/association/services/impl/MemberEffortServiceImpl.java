package com.tech.society.association.services.impl;

import com.tech.society.association.models.MemberEffort;
import com.tech.society.association.repositories.MemberEffortRepository;
import com.tech.society.association.services.MemberEffortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberEffortServiceImpl implements MemberEffortService {

    @Autowired
    private MemberEffortRepository repository;

    @Override
    public MemberEffort save(MemberEffort effort) {
        return repository.save(effort);
    }

    @Override
    public List<MemberEffort> findAll() {
        return repository.findAll();
    }

    @Override
    public MemberEffort findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}