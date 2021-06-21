package com.profitus.nprdbservice.security.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("security")
public class AccessProperties {
    private List<String> whitelistIps;

    public List<String> getWhitelistIps() {
        return whitelistIps;
    }

    public void setWhitelistIps(List<String> whitelistIps) {
        this.whitelistIps = whitelistIps;
    }
}
