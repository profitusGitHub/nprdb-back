package com.profitus.nprdbservice.repository;

import com.profitus.nprdbservice.model.Accounting;
import com.profitus.nprdbservice.model.Instrument;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountingRepository extends CrudRepository<Accounting, Long> {
    Optional<Accounting> findByReportId(String id);
}
