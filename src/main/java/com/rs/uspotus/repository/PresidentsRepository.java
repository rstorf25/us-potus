package com.rs.uspotus.repository;

import com.rs.uspotus.model.President;
import org.springframework.data.repository.CrudRepository;

public interface PresidentsRepository extends CrudRepository<President, Long> {
}
