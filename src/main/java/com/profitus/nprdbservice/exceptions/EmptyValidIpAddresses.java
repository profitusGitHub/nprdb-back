package com.profitus.nprdbservice.exceptions;

public class EmptyValidIpAddresses extends RuntimeException {
    public EmptyValidIpAddresses() {
        super();
    }

    public EmptyValidIpAddresses(String message) {
        super(message);
    }

    public EmptyValidIpAddresses(String message, Throwable cause) {
        super(message, cause);
    }
}
