package com.tech.society.association.controllers;

import com.tech.society.association.models.MinutesOfMeeting;
import com.tech.society.association.services.MinutesOfMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/minutes-of-meeting")
public class MinutesOfMeetingController {

    @Autowired
    private MinutesOfMeetingService service;

    @PostMapping
    public ResponseEntity<MinutesOfMeeting> create(@RequestBody MinutesOfMeeting mom) {
        return ResponseEntity.ok(service.save(mom));
    }

    @GetMapping
    public ResponseEntity<List<MinutesOfMeeting>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MinutesOfMeeting> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}