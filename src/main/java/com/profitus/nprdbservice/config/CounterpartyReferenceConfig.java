package com.profitus.nprdbservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("data.predifined.counterparty-reference")
public class CounterpartyReferenceConfig {
    private String rprtngAgnCd;

    public String getRprtngAgnCd() {
        return rprtngAgnCd;
    }

    public void setRprtngAgnCd(String rprtngAgnCd){
        this.rprtngAgnCd = rprtngAgnCd;
    }
}
