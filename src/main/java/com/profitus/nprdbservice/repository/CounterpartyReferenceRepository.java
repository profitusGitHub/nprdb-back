package com.profitus.nprdbservice.repository;

import com.profitus.nprdbservice.model.CounterpartyReference;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CounterpartyReferenceRepository extends CrudRepository<CounterpartyReference, Long> {
    Optional<CounterpartyReference> findByReportId(String id);
}
