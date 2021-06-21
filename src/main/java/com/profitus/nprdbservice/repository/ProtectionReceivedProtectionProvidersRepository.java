package com.profitus.nprdbservice.repository;

import com.profitus.nprdbservice.model.ProtectionReceivedProtectionProviders;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProtectionReceivedProtectionProvidersRepository extends CrudRepository<ProtectionReceivedProtectionProviders, Long> {
    Optional<ProtectionReceivedProtectionProviders> findByReportId(String id);
}
