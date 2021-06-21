package com.profitus.nprdbservice.controller;

import com.profitus.nprdbservice.service.AccountingGenerator;
import com.profitus.nprdbservice.service.CounterPartyRefereceGenerator;
import com.profitus.nprdbservice.service.InstrumentGenerator;
import com.profitus.nprdbservice.service.ProtectionGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/v1")
public class Generator {
    private final CounterPartyRefereceGenerator counterPartyRefereceGenerator;
    private final AccountingGenerator accountingGenerator;
    private final InstrumentGenerator instrumentGenerator;
    private final ProtectionGenerator protectionGenerator;

    public Generator(CounterPartyRefereceGenerator counterPartyRefereceGenerator, AccountingGenerator accountingGenerator, InstrumentGenerator instrumentGenerator, ProtectionGenerator protectionGenerator) {
        this.counterPartyRefereceGenerator = counterPartyRefereceGenerator;
        this.accountingGenerator = accountingGenerator;
        this.instrumentGenerator = instrumentGenerator;
        this.protectionGenerator = protectionGenerator;
    }

    @RequestMapping(path = "/download/counterparty-reference/{reportId}", method = RequestMethod.GET)
    public ResponseEntity<ByteArrayResource> downloadcounterpartyReference(@PathVariable String reportId) throws IOException {
        File report = counterPartyRefereceGenerator.generate(reportId);
        BufferedReader reader = new BufferedReader(new FileReader(report));
        reader.close();

        Path path = Paths.get(report.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=counterparty-reference"+reportId+".xml")
                .body(resource);
    }

    @RequestMapping(path = "/download/accounting/{reportId}", method = RequestMethod.GET)
    public ResponseEntity<ByteArrayResource> downloadAccounting(@PathVariable String reportId) throws IOException {
        File report = accountingGenerator.generate(reportId);
        BufferedReader reader = new BufferedReader(new FileReader(report));
        reader.close();

        Path path = Paths.get(report.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=counterparty-reference"+reportId+".xml")
                .body(resource);
    }

    @RequestMapping(path = "/download/instrument/{reportId}", method = RequestMethod.GET)
    public ResponseEntity<ByteArrayResource> downloadInstrument(@PathVariable String reportId) throws IOException {
        File report = instrumentGenerator.generate(reportId);
        BufferedReader reader = new BufferedReader(new FileReader(report));
        reader.close();

        Path path = Paths.get(report.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=counterparty-reference"+reportId+".xml")
                .body(resource);
    }

    @RequestMapping(path = "/download/protection/{reportId}", method = RequestMethod.GET)
    public ResponseEntity<ByteArrayResource> downloadProtection(@PathVariable String reportId) throws IOException {
        File report = protectionGenerator.generate(reportId);
        BufferedReader reader = new BufferedReader(new FileReader(report));
        reader.close();

        Path path = Paths.get(report.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=counterparty-reference"+reportId+".xml")
                .body(resource);
    }

}
