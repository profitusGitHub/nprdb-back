package com.profitus.nprdbservice.repository;

import com.profitus.nprdbservice.model.Accounting;
import com.profitus.nprdbservice.model.JointLiabilities;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface JointLiabilitiesRepository extends CrudRepository<JointLiabilities, Long> {
    Optional<JointLiabilities> findByReportId(String id);
}
