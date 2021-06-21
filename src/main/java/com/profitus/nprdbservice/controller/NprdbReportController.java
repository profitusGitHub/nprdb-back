package com.profitus.nprdbservice.controller;

import com.profitus.nprdbservice.model.MainNprdbReport;
import com.profitus.nprdbservice.repository.MainNprdbReportRepository;
import com.profitus.nprdbservice.service.Initializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/v1")
public class NprdbReportController {
    private final MainNprdbReportRepository repository;
    private final Initializer initializer;

    public NprdbReportController(MainNprdbReportRepository repository, Initializer initializer) {
        this.repository = repository;
        this.initializer = initializer;
    }

    @GetMapping("/ping")
    public String getInternalIp(HttpServletRequest request) {
       return request.getRemoteAddr();
    }

    @PostMapping("/report-main")
    public ResponseEntity<MainNprdbReport> createCounterpartyReference(@RequestBody MainNprdbReport data) {
        initializer.initReport(data);
        return new ResponseEntity(repository.save(data), HttpStatus.CREATED);
    }

    @GetMapping("/report-main")
    public ResponseEntity<List<MainNprdbReport>> getCounterpartyReference() {
        return new ResponseEntity(repository.findAllByOrderByCreateDateTimeDesc(), HttpStatus.OK);
    }

    @GetMapping("/report-main/{id}")
    public ResponseEntity<MainNprdbReport> getMainReportById(@PathVariable String id) {
        Optional<MainNprdbReport> mainNprdbReport = repository.findByReportId(id);
        if (mainNprdbReport.isPresent()) {
            return new ResponseEntity(mainNprdbReport.get(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/report-main/sorted/{prop}")
    public ResponseEntity<List<MainNprdbReport>> getSortedMainNprdbReports(@PathVariable String prop) {
        List<MainNprdbReport> nprdbReports = repository.findAll();
        List<MainNprdbReport> orderedReports = nprdbReports.stream()
                .filter(project -> project.getStatus().equals(prop))
                .collect(Collectors.toList());
        orderedReports.addAll(nprdbReports.stream()
                .filter(project -> !project.getStatus().equals(prop))
                .collect(Collectors.toList()));
        return new ResponseEntity<>(orderedReports, HttpStatus.OK);
    }

    @GetMapping("/report-main/delete/{prop}/{code}")
    public ResponseEntity<Void> deleteReport(@PathVariable String prop, @PathVariable String code){
        if("20211202".equals(code)) {
            repository.deleteReport(prop);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
