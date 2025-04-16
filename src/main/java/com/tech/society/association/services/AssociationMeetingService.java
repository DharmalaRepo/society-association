package com.tech.society.association.services;

import com.tech.society.association.models.AssociationMeeting;
import java.util.List;

public interface AssociationMeetingService {
    AssociationMeeting save(AssociationMeeting meeting);
    List<AssociationMeeting> findAll();
    AssociationMeeting findById(String id);
    void deleteById(String id);
}