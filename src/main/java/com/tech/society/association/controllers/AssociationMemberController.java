package com.tech.society.association.controllers;

import com.tech.society.association.models.AssociationMember;
import com.tech.society.association.services.AssociationMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/association-members")
public class AssociationMemberController {

    @Autowired
    private AssociationMemberService service;

    @GetMapping("/health")
    public ResponseEntity<?> health() {
        return ResponseEntity.ok("Hello, welcome to Society Association Service..!!");
    }

    @PostMapping
    public ResponseEntity<AssociationMember> create(@RequestBody AssociationMember member) {
        return ResponseEntity.ok(service.save(member));
    }

    @GetMapping
    public ResponseEntity<List<AssociationMember>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssociationMember> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}