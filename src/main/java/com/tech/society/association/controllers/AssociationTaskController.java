package com.tech.society.association.controllers;

import com.tech.society.association.models.AssociationTask;
import com.tech.society.association.services.AssociationTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/association-tasks")
public class AssociationTaskController {

    @Autowired
    private AssociationTaskService service;

    @PostMapping
    public ResponseEntity<AssociationTask> create(@RequestBody AssociationTask task) {
        return ResponseEntity.ok(service.save(task));
    }

    @GetMapping
    public ResponseEntity<List<AssociationTask>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssociationTask> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}