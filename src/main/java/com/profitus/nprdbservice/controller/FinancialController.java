package com.profitus.nprdbservice.controller;

import com.profitus.nprdbservice.model.Financial;
import com.profitus.nprdbservice.repository.FinancialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/v1")
public class FinancialController {
    private final FinancialRepository repository;

    public FinancialController(FinancialRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/financial")
    public ResponseEntity<Financial> createCounterpartyReference(@RequestBody Financial data){
        return new ResponseEntity(repository.save(data), HttpStatus.CREATED);
    }

    @PutMapping("/financial/{id}")
    public ResponseEntity<Financial> updateCounterpartyReference(@RequestBody Financial data, @PathVariable String id){
        Optional<Financial> reportEntity = repository.findByReportId(id);
        if(reportEntity.isPresent()){
            Financial report = reportEntity.get();
            data.setId(report.getId());
            repository.save(data);
        } else {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity(data, HttpStatus.OK);
    }

    @GetMapping("/financial/{id}")
    public ResponseEntity<Financial> getCounterpartyReference(@PathVariable String id){
        Optional<Financial> reportEntity = repository.findByReportId(id);
        if(reportEntity.isPresent()){
            return ResponseEntity.ok(reportEntity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
