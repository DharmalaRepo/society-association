package com.tech.society.association.services.impl;

import com.tech.society.association.models.CommunicationLog;
import com.tech.society.association.repositories.CommunicationLogRepository;
import com.tech.society.association.services.CommunicationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunicationLogServiceImpl implements CommunicationLogService {

    @Autowired
    private CommunicationLogRepository repository;

    @Override
    public CommunicationLog save(CommunicationLog log) {
        return repository.save(log);
    }

    @Override
    public List<CommunicationLog> findAll() {
        return repository.findAll();
    }

    @Override
    public CommunicationLog findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}