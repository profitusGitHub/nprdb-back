package com.profitus.nprdbservice.repository;

import com.profitus.nprdbservice.model.ProtectionReceived;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProtectionReceivedRepository extends CrudRepository<ProtectionReceived, Long> {
/*    void removeByReportId(String reportId);*/
    void deleteByReportId(String reportId);
    List<ProtectionReceived> findByReportId(String id);
}
