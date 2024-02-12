package com.rs.uspotus.service;

import com.rs.uspotus.model.President;
import com.rs.uspotus.repository.PresidentsRepository;
import org.springframework.stereotype.Service;


@Service
public class PresidentsService {

    private final PresidentsRepository presidentsRepository;

    public PresidentsService(PresidentsRepository presidentsRepository){
        this.presidentsRepository = presidentsRepository;
    }

    public President addPresident(President president){
        return presidentsRepository.save(president);
    }

    public Iterable<President> getAllPresidents(){
        return presidentsRepository.findAll();
    }

}
