package com.profitus.nprdbservice.controller;

import com.profitus.nprdbservice.model.MainNprdbReport;
import com.profitus.nprdbservice.model.ProjectStatus;
import com.profitus.nprdbservice.repository.MainNprdbReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjectStatusController {
    private final MainNprdbReportRepository mainNprdbReportRepository;

    public ProjectStatusController(MainNprdbReportRepository mainNprdbReportRepository) {
        this.mainNprdbReportRepository = mainNprdbReportRepository;
    }

    @PostMapping("/status")
    public ResponseEntity<Void> updateNprdbReport(@RequestBody ProjectStatus data) {
        Optional<MainNprdbReport> reportWrapper = mainNprdbReportRepository.findByReportId(data.getReportId());
        if (reportWrapper.isPresent()) {
            MainNprdbReport report = reportWrapper.get();
            if (data.getStatus() != null && !data.getStatus().isEmpty()) {
                report.setStatus(data.getStatus());
            }
            mainNprdbReportRepository.save(report);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/default/q1w2e3r4t5y")
    public ResponseEntity<Void> defaultNprdbReportStatus() {
        mainNprdbReportRepository.updateToDefaultStatus();
        return ResponseEntity.notFound().build();
    }
}
