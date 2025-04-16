package com.tech.society.association.services;

import com.tech.society.association.models.CommunicationLog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommunicationLogService {
    CommunicationLog save(CommunicationLog log);
    List<CommunicationLog> findAll();
    CommunicationLog findById(String id);
    void deleteById(String id);
}