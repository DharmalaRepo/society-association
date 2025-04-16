package com.tech.society.association.controllers;

import com.tech.society.association.models.CommunicationLog;
import com.tech.society.association.services.CommunicationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/communication-logs")
public class CommunicationLogController {

    @Autowired
    private CommunicationLogService service;

    @PostMapping
    public ResponseEntity<CommunicationLog> create(@RequestBody CommunicationLog log) {
        return ResponseEntity.ok(service.save(log));
    }

    @GetMapping
    public ResponseEntity<List<CommunicationLog>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommunicationLog> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}