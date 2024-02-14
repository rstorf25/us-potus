package com.rs.uspotus.controllers;

import com.rs.uspotus.model.President;
import com.rs.uspotus.service.PresidentsService;
import jakarta.validation.Valid;
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
    public ResponseEntity<President> addPresident(@Valid @RequestBody President president) {
        President newPresident = presidentsService.addPresident(president);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPresident);
    }

    @GetMapping
    public ResponseEntity<Iterable<President>> getAllPresidents() {
        Iterable<President> presidents = presidentsService.getAllPresidents();
        return ResponseEntity.ok(presidents);
    }

    @PutMapping("/{id}")
    public ResponseEntity<President> updatePresident(@Valid @PathVariable Long id, @RequestBody President updatedPresident) {
        if (updatedPresident.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        Optional<President> presidentOptional = presidentsService.getPresidentById(id);
        if (presidentOptional.isPresent()) {
            President updatedPres = presidentsService.updatePresident(updatedPresident);
            return ResponseEntity.ok(updatedPres);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<President> getPresidentById(@PathVariable Long id) {
        Optional<President> optPres = presidentsService.getPresidentById(id);
        return optPres.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePresident(@PathVariable Long id) {
        Optional<President> presidentOptional = presidentsService.getPresidentById(id);
        if (presidentOptional.isPresent()) {
            presidentsService.removePresidentById(id);
            return ResponseEntity.noContent().build();

        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
