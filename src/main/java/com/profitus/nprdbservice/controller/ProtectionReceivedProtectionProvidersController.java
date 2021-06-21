package com.profitus.nprdbservice.controller;

import com.profitus.nprdbservice.model.ProtectionReceivedProtectionProviders;
import com.profitus.nprdbservice.repository.ProtectionReceivedProtectionProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/v1")
public class ProtectionReceivedProtectionProvidersController {
    private final ProtectionReceivedProtectionProvidersRepository repository;

    public ProtectionReceivedProtectionProvidersController(ProtectionReceivedProtectionProvidersRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/protection-received-protection-providers")
    public ResponseEntity<ProtectionReceivedProtectionProviders> createCounterpartyReference(@RequestBody ProtectionReceivedProtectionProviders data){
        return new ResponseEntity(repository.save(data), HttpStatus.CREATED);
    }

    @PutMapping("/protection-received-protection-providers/{id}")
    public ResponseEntity<ProtectionReceivedProtectionProviders> updateCounterpartyReference(@RequestBody ProtectionReceivedProtectionProviders data, @PathVariable String id){
        Optional<ProtectionReceivedProtectionProviders> reportEntity = repository.findByReportId(id);
        if(reportEntity.isPresent()){
            ProtectionReceivedProtectionProviders report = reportEntity.get();
            data.setId(report.getId());
            repository.save(data);
        } else {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity(data, HttpStatus.OK);
    }

    @GetMapping("/protection-received-protection-providers/{id}")
    public ResponseEntity<ProtectionReceivedProtectionProviders> getCounterpartyReference(@PathVariable String id){
        Optional<ProtectionReceivedProtectionProviders> reportEntity = repository.findByReportId(id);
        if(reportEntity.isPresent()){
            return ResponseEntity.ok(reportEntity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
