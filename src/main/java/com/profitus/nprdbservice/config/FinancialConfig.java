package com.profitus.nprdbservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("data.predifined.financial")
public class FinancialConfig {
    private String typScrtstn;

    public String getTypScrtstn() {
        return typScrtstn;
    }

    public void setTypScrtstn(String typScrtstn) {
        this.typScrtstn = typScrtstn;
    }
}
