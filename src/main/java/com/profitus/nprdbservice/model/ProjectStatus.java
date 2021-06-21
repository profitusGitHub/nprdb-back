package com.profitus.nprdbservice.model;

public class ProjectStatus {
    private String reportId;
    private String status;
    private String validationCode;

    public ProjectStatus() {
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValidationCode() {
        return validationCode;
    }

    public void setValidationCode(String code) {
        this.validationCode = code;
    }
}
