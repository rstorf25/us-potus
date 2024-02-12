package com.rs.uspotus.controllers;

import com.rs.uspotus.model.President;
import com.rs.uspotus.service.PresidentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/presidents")
public class PresidentsController {

    private final PresidentsService presidentsService;

    public PresidentsController(PresidentsService presidentsService) {
        this.presidentsService = presidentsService;
    }

    @PostMapping
    public ResponseEntity<President> addPresident(@RequestBody President president) {
        President newPresident = presidentsService.addPresident(president);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPresident);
    }

    @GetMapping
    public ResponseEntity<Iterable<President>> getAllPresidents() {
        Iterable<President> presidents = presidentsService.getAllPresidents();
        return ResponseEntity.ok(presidents);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePresident(@PathVariable Integer id) {
        Optional<President> presidentOptional = presidentsService.findPresidentById(id);
        if (presidentOptional.isPresent()) {
            presidentsService.removePresidentById(id);
            return ResponseEntity.noContent().build();

        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
