package com.profitus.nprdbservice.controller;

import com.profitus.nprdbservice.model.Instrument;
import com.profitus.nprdbservice.repository.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InstrumentController {

    private final InstrumentRepository repository;

    public InstrumentController(InstrumentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/instrument")
    public ResponseEntity<Instrument> createCounterpartyReference(@RequestBody Instrument data){
        return new ResponseEntity(repository.save(data), HttpStatus.CREATED);
    }

    @PutMapping("/instrument/{id}")
    public ResponseEntity<Instrument> updateCounterpartyReference(@RequestBody Instrument data, @PathVariable String id){
        Optional<Instrument> reportEntity = repository.findByReportId(id);
        if(reportEntity.isPresent()){
            Instrument report = reportEntity.get();
            data.setId(report.getId());
            repository.save(data);
        } else {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity(data, HttpStatus.OK);
    }

    @GetMapping("/instrument/{id}")
    public ResponseEntity<Instrument> getCounterpartyReference(@PathVariable String id){
        Optional<Instrument> reportEntity = repository.findByReportId(id);
        if(reportEntity.isPresent()){
            return ResponseEntity.ok(reportEntity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
