package com.profitus.nprdbservice.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class MainNprdbReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reportId;
    private String reportName;
    private boolean msg1Delivered = false;
    private boolean msg2Delivered = false;
    private boolean msg3Delivered = false;
    private boolean msg4Delivered = false;
    private String status = "Pildoma";

    @CreationTimestamp
    private Date createDateTime;
    @UpdateTimestamp
    private Date updateDateTime;

    @PrePersist
    protected void onCreate() {
        this.createDateTime = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updateDateTime = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public boolean isMsg1Delivered() {
        return msg1Delivered;
    }

    public void setMsg1Delivered(boolean msg1Delivered) {
        this.msg1Delivered = msg1Delivered;
    }

    public boolean isMsg2Delivered() {
        return msg2Delivered;
    }

    public void setMsg2Delivered(boolean msg2Delivered) {
        this.msg2Delivered = msg2Delivered;
    }

    public boolean isMsg3Delivered() {
        return msg3Delivered;
    }

    public void setMsg3Delivered(boolean msg3Delivered) {
        this.msg3Delivered = msg3Delivered;
    }

    public boolean isMsg4Delivered() {
        return msg4Delivered;
    }

    public void setMsg4Delivered(boolean msg4Delivered) {
        this.msg4Delivered = msg4Delivered;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
