package com.profitus.nprdbservice.controller;

import com.profitus.nprdbservice.model.ProtectionReceived;
import com.profitus.nprdbservice.repository.ProtectionReceivedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/v1")
public class ProtectionReceivedController {
    private final ProtectionReceivedRepository repository;

    public ProtectionReceivedController(ProtectionReceivedRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/protection-received")
    public ResponseEntity<List<ProtectionReceived>> createCounterpartyReference(@RequestBody List<ProtectionReceived> data){
        List<ProtectionReceived> response = Collections.emptyList();
        for(ProtectionReceived protection: data){
            removeProtections(protection.getReportId());
            response.add(repository.save(protection));
        }
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping("/protection-received/{id}")
    public ResponseEntity<List<ProtectionReceived>> updateCounterpartyReference(@RequestBody List<ProtectionReceived> data,
                                                                                @PathVariable String id){
        removeProtections(id);
        for(ProtectionReceived protection: data){
             repository.save(protection);
        }
        return new ResponseEntity(repository.findByReportId(id), HttpStatus.CREATED);
    }

    @GetMapping("/protection-received/{id}")
    public ResponseEntity<List<ProtectionReceived>> getCounterpartyReference(@PathVariable String id){
        return ResponseEntity.ok(repository.findByReportId(id));
    }

    private void removeProtections(String reportId){
        List<ProtectionReceived> protections = repository.findByReportId(reportId);
        try {
            for (ProtectionReceived protection : protections) {
                repository.delete(protection);
            }
        } catch (Exception e){ }
    }
}
