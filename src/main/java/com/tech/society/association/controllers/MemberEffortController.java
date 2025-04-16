package com.tech.society.association.controllers;

import com.tech.society.association.models.MemberEffort;
import com.tech.society.association.services.MemberEffortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member-efforts")
public class MemberEffortController {

    @Autowired
    private MemberEffortService service;

    @PostMapping
    public ResponseEntity<MemberEffort> create(@RequestBody MemberEffort effort) {
        return ResponseEntity.ok(service.save(effort));
    }

    @GetMapping
    public ResponseEntity<List<MemberEffort>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberEffort> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}