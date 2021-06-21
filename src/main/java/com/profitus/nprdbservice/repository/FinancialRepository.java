package com.profitus.nprdbservice.repository;

import com.profitus.nprdbservice.model.Financial;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FinancialRepository extends CrudRepository<Financial, Long> {
    Optional<Financial> findByReportId(String id);
}
