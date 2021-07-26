package com.profitus.nprdbservice.security;

import com.profitus.nprdbservice.exceptions.EmptyValidIpAddresses;
import com.profitus.nprdbservice.security.properties.AccessProperties;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.stream.Collectors;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AccessProperties accessProperties;

    public SecurityConfig(AccessProperties accessProperties) {
        this.accessProperties = accessProperties;
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors().disable();
        httpSecurity.csrf().disable();
        httpSecurity
                .authorizeRequests()
                .anyRequest()
                .access(validIpExpressionBuilder());
    }

    private String validIpExpressionBuilder() {
        if (accessProperties.getWhitelistIps().isEmpty()) {
            throw new EmptyValidIpAddresses();
        }
        return accessProperties.getWhitelistIps().stream()
                .collect(Collectors.joining("') or hasIpAddress('", "hasIpAddress('", "')"));
    }
}
