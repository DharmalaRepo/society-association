package com.tech.society.association.services;

import com.tech.society.association.models.AssociationTask;
import java.util.List;

public interface AssociationTaskService {
    AssociationTask save(AssociationTask task);
    List<AssociationTask> findAll();
    AssociationTask findById(String id);
    void deleteById(String id);
}