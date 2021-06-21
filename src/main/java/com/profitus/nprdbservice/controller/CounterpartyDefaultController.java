package com.profitus.nprdbservice.controller;

import com.profitus.nprdbservice.model.CounterpartyDefault;
import com.profitus.nprdbservice.repository.CounterpartyDefaultRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/v1")
public class CounterpartyDefaultController {
    private final CounterpartyDefaultRepository repository;

    public CounterpartyDefaultController(CounterpartyDefaultRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/counterparty-default")
    public ResponseEntity<CounterpartyDefault> createCounterpartyReference(@RequestBody CounterpartyDefault data){
        return new ResponseEntity(repository.save(data), HttpStatus.CREATED);
    }

    @PutMapping("/counterparty-default/{id}")
    public ResponseEntity<CounterpartyDefault> updateCounterpartyReference(@RequestBody CounterpartyDefault data, @PathVariable String id){
        Optional<CounterpartyDefault> reportEntity = repository.findByReportId(id);
        if(reportEntity.isPresent()){
            CounterpartyDefault report = reportEntity.get();
            data.setId(report.getId());
            repository.save(data);
        } else {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity(data, HttpStatus.OK);
    }

    @GetMapping("/counterparty-default/{id}")
    public ResponseEntity<CounterpartyDefault> getCounterpartyReference(@PathVariable String id){
        Optional<CounterpartyDefault> reportEntity = repository.findByReportId(id);
        if(reportEntity.isPresent()){
            return ResponseEntity.ok(reportEntity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
