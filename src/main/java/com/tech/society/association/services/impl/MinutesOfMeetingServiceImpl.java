package com.tech.society.association.services.impl;

import com.tech.society.association.models.MinutesOfMeeting;
import com.tech.society.association.repositories.MinutesOfMeetingRepository;
import com.tech.society.association.services.MinutesOfMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MinutesOfMeetingServiceImpl implements MinutesOfMeetingService {

    @Autowired
    private MinutesOfMeetingRepository repository;

    @Override
    public MinutesOfMeeting save(MinutesOfMeeting mom) {
        return repository.save(mom);
    }

    @Override
    public List<MinutesOfMeeting> findAll() {
        return repository.findAll();
    }

    @Override
    public MinutesOfMeeting findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}