package com.profitus.nprdbservice.repository;

import com.profitus.nprdbservice.model.Instrument;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface InstrumentRepository extends CrudRepository<Instrument, Long> {
    Optional<Instrument> findByReportId(String id);
}
