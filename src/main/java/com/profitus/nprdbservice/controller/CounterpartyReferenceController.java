package com.profitus.nprdbservice.controller;

import com.profitus.nprdbservice.model.CounterpartyReference;
import com.profitus.nprdbservice.repository.CounterpartyReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/v1")
public class CounterpartyReferenceController {
    private final CounterpartyReferenceRepository repository;

    public CounterpartyReferenceController(CounterpartyReferenceRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/counterparty-reference")
    public ResponseEntity<CounterpartyReference> createCounterpartyReference(@RequestBody CounterpartyReference data){
        return new ResponseEntity(repository.save(data), HttpStatus.CREATED);
    }

    @PutMapping("/counterparty-reference/{id}")
    public ResponseEntity<CounterpartyReference> updateCounterpartyReference(@RequestBody CounterpartyReference data, @PathVariable String id){
        Optional<CounterpartyReference> reportEntity = repository.findByReportId(id);
        if(reportEntity.isPresent()){
            CounterpartyReference report = reportEntity.get();
            data.setId(report.getId());
            repository.save(data);
        } else {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity(data, HttpStatus.OK);
    }

    @GetMapping("/counterparty-reference/{id}")
    public ResponseEntity<CounterpartyReference> getCounterpartyReference(@PathVariable String id){
        Optional<CounterpartyReference> reportEntity = repository.findByReportId(id);
        if(reportEntity.isPresent()){
            return ResponseEntity.ok(reportEntity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
