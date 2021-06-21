package com.profitus.nprdbservice.repository;

import com.profitus.nprdbservice.model.MainNprdbReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface MainNprdbReportRepository extends JpaRepository<MainNprdbReport, Long> {
    List<MainNprdbReport> findAllByOrderByCreateDateTimeDesc();

    Optional<MainNprdbReport> findByReportId(String reportId);

    List<MainNprdbReport> findAllOrderByStatus(String status);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update main_nprdb_report SET status = 'Pildoma'")
    void updateToDefaultStatus();

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from main_nprdb_report where report_id =:reportId")
    void deleteReport(String reportId);
}
