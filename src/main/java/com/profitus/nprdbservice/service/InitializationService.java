package com.profitus.nprdbservice.service;

import com.profitus.nprdbservice.config.CounterpartyReferenceConfig;
import com.profitus.nprdbservice.config.FinancialConfig;
import com.profitus.nprdbservice.model.CounterpartyReference;
import com.profitus.nprdbservice.model.Financial;
import com.profitus.nprdbservice.model.MainNprdbReport;
import com.profitus.nprdbservice.repository.CounterpartyReferenceRepository;
import com.profitus.nprdbservice.repository.FinancialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitializationService implements Initializer {
    @Autowired
    private CounterpartyReferenceRepository counterpartyReferenceRepository;
    @Autowired
    private FinancialRepository financialRepository;
    @Autowired
    private FinancialConfig financialConfig;
    @Autowired
    private CounterpartyReferenceConfig counterpartyReferenceConfig;

    @Override
    public void initReport(MainNprdbReport mainNprdbReport) {
        CounterpartyReference counterpartyReference = new CounterpartyReference();
        counterpartyReference.setReportId(mainNprdbReport.getReportId());
        counterpartyReference.setRprtngAgnCd(counterpartyReferenceConfig.getRprtngAgnCd());
        Financial financial = new Financial();
        financial.setTypScrtstn(financialConfig.getTypScrtstn());
        financial.setReportId(mainNprdbReport.getReportId());
        counterpartyReferenceRepository.save(counterpartyReference);
        financialRepository.save(financial);
    }
}
