package com.tech.society.association.services.impl;

import com.tech.society.association.models.AssociationTask;
import com.tech.society.association.repositories.AssociationTaskRepository;
import com.tech.society.association.services.AssociationTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociationTaskServiceImpl implements AssociationTaskService {

    @Autowired
    private AssociationTaskRepository repository;

    @Override
    public AssociationTask save(AssociationTask task) {
        return repository.save(task);
    }

    @Override
    public List<AssociationTask> findAll() {
        return repository.findAll();
    }

    @Override
    public AssociationTask findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}