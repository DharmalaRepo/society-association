package com.tech.society.association.services.impl;

import com.tech.society.association.models.AssociationMeeting;
import com.tech.society.association.repositories.AssociationMeetingRepository;
import com.tech.society.association.services.AssociationMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociationMeetingServiceImpl implements AssociationMeetingService {

    @Autowired
    private AssociationMeetingRepository repository;

    @Override
    public AssociationMeeting save(AssociationMeeting meeting) {
        return repository.save(meeting);
    }

    @Override
    public List<AssociationMeeting> findAll() {
        return repository.findAll();
    }

    @Override
    public AssociationMeeting findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }


}