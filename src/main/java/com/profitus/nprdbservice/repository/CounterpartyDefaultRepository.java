package com.profitus.nprdbservice.repository;

import com.profitus.nprdbservice.model.Accounting;
import com.profitus.nprdbservice.model.CounterpartyDefault;
import com.profitus.nprdbservice.model.Instrument;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CounterpartyDefaultRepository extends CrudRepository<CounterpartyDefault, Long> {
    Optional<CounterpartyDefault> findByReportId(String id);
}
