package com.profitus.nprdbservice.repository;

import com.profitus.nprdbservice.model.Accounting;
import com.profitus.nprdbservice.model.CounterpartyInstrument;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CounterpartyInstrumentRepository extends CrudRepository<CounterpartyInstrument, Long> {
    Optional<CounterpartyInstrument> findByReportId(String id);
}
