package com.profitus.nprdbservice.controller;

import com.profitus.nprdbservice.model.CounterpartyInstrument;
import com.profitus.nprdbservice.repository.CounterpartyInstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/v1")
public class CounterpartyInstrumentController {
    private final CounterpartyInstrumentRepository repository;

    public CounterpartyInstrumentController(CounterpartyInstrumentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/counterparty-instrument")
    public ResponseEntity<CounterpartyInstrument> createCounterpartyReference(@RequestBody CounterpartyInstrument data){
        return new ResponseEntity(repository.save(data), HttpStatus.CREATED);
    }

    @PutMapping("/counterparty-instrument/{id}")
    public ResponseEntity<CounterpartyInstrument> updateCounterpartyReference(@RequestBody CounterpartyInstrument data, @PathVariable String id){
        Optional<CounterpartyInstrument> reportEntity = repository.findByReportId(id);
        if(reportEntity.isPresent()){
            CounterpartyInstrument report = reportEntity.get();
            data.setId(report.getId());
            repository.save(data);
        } else {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity(data, HttpStatus.OK);
    }

    @GetMapping("/counterparty-instrument/{id}")
    public ResponseEntity<CounterpartyInstrument> getCounterpartyReference(@PathVariable String id){
        Optional<CounterpartyInstrument> reportEntity = repository.findByReportId(id);
        if(reportEntity.isPresent()){
            return ResponseEntity.ok(reportEntity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
