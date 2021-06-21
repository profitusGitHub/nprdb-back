package com.profitus.nprdbservice.repository;

import com.profitus.nprdbservice.model.Accounting;
import com.profitus.nprdbservice.model.InstrumentProtection;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface InstrumentProtectionRepository extends CrudRepository<InstrumentProtection, Long> {
    Optional<InstrumentProtection> findByReportId(String id);
}
