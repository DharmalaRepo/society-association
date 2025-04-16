
package com.tech.society.association.controllers;

        import com.tech.society.association.models.AssociationMeeting;
        import com.tech.society.association.services.AssociationMeetingService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/association-meetings")
public class AssociationMeetingController {

    @Autowired
    private AssociationMeetingService service;

    @PostMapping
    public ResponseEntity<AssociationMeeting> create(@RequestBody AssociationMeeting meeting) {
        return ResponseEntity.ok(service.save(meeting));
    }

    @GetMapping
    public ResponseEntity<List<AssociationMeeting>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssociationMeeting> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}