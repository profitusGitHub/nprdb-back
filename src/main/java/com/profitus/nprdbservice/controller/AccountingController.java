package com.profitus.nprdbservice.controller;

import com.profitus.nprdbservice.model.Accounting;
import com.profitus.nprdbservice.repository.AccountingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/v1")
public class AccountingController {
    private final AccountingRepository repository;

    public AccountingController(AccountingRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/accounting")
    public ResponseEntity<Accounting> createCounterpartyReference(@RequestBody Accounting data){
        return new ResponseEntity(repository.save(data), HttpStatus.CREATED);
    }

    @PutMapping("/accounting/{id}")
    public ResponseEntity<Accounting> updateCounterpartyReference(@RequestBody Accounting data, @PathVariable String id){
        Optional<Accounting> reportEntity = repository.findByReportId(id);
        if(reportEntity.isPresent()){
            Accounting report = reportEntity.get();
            data.setId(report.getId());
            repository.save(data);
        } else {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity(data, HttpStatus.OK);
    }

    @GetMapping("/accounting/{id}")
    public ResponseEntity<Accounting> getCounterpartyReference(@PathVariable String id){
        Optional<Accounting> reportEntity = repository.findByReportId(id);
        if(reportEntity.isPresent()){
            return ResponseEntity.ok(reportEntity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
