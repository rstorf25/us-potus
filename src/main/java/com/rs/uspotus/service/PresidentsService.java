package com.rs.uspotus.service;

import com.rs.uspotus.model.President;
import com.rs.uspotus.repository.PresidentsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PresidentsService {

    private final PresidentsRepository presidentsRepository;

    public PresidentsService(PresidentsRepository presidentsRepository) {
        this.presidentsRepository = presidentsRepository;
    }

    public President addPresident(President president) {
        return presidentsRepository.save(president);
    }

    public President updatePresident(President president) {
        return presidentsRepository.save(president);
    }

    public Iterable<President> getAllPresidents() {
        return presidentsRepository.findAll();
    }

    public Optional<President> getPresidentById(Long id) {
        return presidentsRepository.findById(id);
    }

    public void removePresidentById(Long id) {
        presidentsRepository.deleteById(id);
    }

}
