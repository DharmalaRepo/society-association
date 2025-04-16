package com.tech.society.association.services;

import com.tech.society.association.models.MinutesOfMeeting;
import java.util.List;

public interface MinutesOfMeetingService {
    MinutesOfMeeting save(MinutesOfMeeting mom);
    List<MinutesOfMeeting> findAll();
    MinutesOfMeeting findById(String id);
    void deleteById(String id);
}