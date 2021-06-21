package com.profitus.nprdbservice.controller;

import com.profitus.nprdbservice.model.JointLiabilities;
import com.profitus.nprdbservice.repository.JointLiabilitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/v1")
public class JointLiabilitiesController {
    private final JointLiabilitiesRepository repository;

    public JointLiabilitiesController(JointLiabilitiesRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/joint-liabilities")
    public ResponseEntity<JointLiabilities> createCounterpartyReference(@RequestBody JointLiabilities data){
        return new ResponseEntity(repository.save(data), HttpStatus.CREATED);
    }

    @PutMapping("/joint-liabilities/{id}")
    public ResponseEntity<JointLiabilities> updateCounterpartyReference(@RequestBody JointLiabilities data, @PathVariable String id){
        Optional<JointLiabilities> reportEntity = repository.findByReportId(id);
        if(reportEntity.isPresent()){
            JointLiabilities report = reportEntity.get();
            data.setId(report.getId());
            repository.save(data);
        } else {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity(data, HttpStatus.OK);
    }

    @GetMapping("/joint-liabilities/{id}")
    public ResponseEntity<JointLiabilities> getCounterpartyReference(@PathVariable String id){
        Optional<JointLiabilities> reportEntity = repository.findByReportId(id);
        if(reportEntity.isPresent()){
            return ResponseEntity.ok(reportEntity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
