package com.profitus.nprdbservice.controller;

import com.profitus.nprdbservice.model.InstrumentProtection;
import com.profitus.nprdbservice.repository.InstrumentProtectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/v1")
public class InstrumentProtectionController {
    private final InstrumentProtectionRepository repository;

    public InstrumentProtectionController(InstrumentProtectionRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/instrument-protection")
    public ResponseEntity<InstrumentProtection> createCounterpartyReference(@RequestBody InstrumentProtection data){
        return new ResponseEntity(repository.save(data), HttpStatus.CREATED);
    }

    @PutMapping("/instrument-protection/{id}")
    public ResponseEntity<InstrumentProtection> updateCounterpartyReference(@RequestBody InstrumentProtection data, @PathVariable String id){
        Optional<InstrumentProtection> reportEntity = repository.findByReportId(id);
        if(reportEntity.isPresent()){
            InstrumentProtection report = reportEntity.get();
            data.setId(report.getId());
            repository.save(data);
        } else {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity(data, HttpStatus.OK);
    }

    @GetMapping("/instrument-protection/{id}")
    public ResponseEntity<InstrumentProtection> getCounterpartyReference(@PathVariable String id){
        Optional<InstrumentProtection> reportEntity = repository.findByReportId(id);
        if(reportEntity.isPresent()){
            return ResponseEntity.ok(reportEntity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
