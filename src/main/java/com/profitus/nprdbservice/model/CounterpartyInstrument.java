package com.profitus.nprdbservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CounterpartyInstrument extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reportId;
    private String rprtngAgntCd;
    private String obsrvdAgntCd;
    private String entityPrdbCd;
    private String cntrctId;
    private String instrmntId;
    private String enttyRl;

    public CounterpartyInstrument() {
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

    public String getRprtngAgntCdXML() {
        if(rprtngAgntCd != null) {
            return "RPRTNG_AGNT_CD=\""+rprtngAgntCd+"\"";
        } else {
            return "";
        }
    }

    public void setRprtngAgntCd(String rprtngAgntCd) {
        this.rprtngAgntCd = rprtngAgntCd;
    }

    public String getObsrvdAgntCdXML() {
        if(obsrvdAgntCd != null) {
            return "OBSRVD_AGNT_CD=\""+obsrvdAgntCd+"\"";
        } else {
            return "";
        }
    }

    public void setObsrvdAgntCd(String obsrvdAgntCd) {
        this.obsrvdAgntCd = obsrvdAgntCd;
    }

    public String getEntityPrdbCdXML() {
        if(entityPrdbCd != null) {
            return "ENTTY_PRDB_CD=\""+entityPrdbCd+"\"";
        } else {
            return "";
        }
    }

    public void setEntityPrdbCd(String entityPrdbCd) {
        this.entityPrdbCd = entityPrdbCd;
    }

    public String getCntrctIdXML() {
        if(cntrctId != null) {
            return "CNTRCT_ID=\""+cntrctId+"\"";
        } else {
            return "";
        }
    }

    public void setCntrctId(String cntrctId) {
        this.cntrctId = cntrctId;
    }

    public String getInstrmntIdXML() {
        if(instrmntId != null) {
            return "INSTRMNT_ID=\""+instrmntId+"\"";
        } else {
            return "";
        }
    }

    public void setInstrmntId(String instrmntId) {
        this.instrmntId = instrmntId;
    }

    public String getEnttyRlXML() {
        if(enttyRl != null) {
            return "ENTTY_RL=\""+enttyRl+"\"";
        } else {
            return "";
        }
    }

    public void setEnttyRl(String enttyRl) {
        this.enttyRl = enttyRl;
    }

    public String getRprtngAgntCd() {
        return rprtngAgntCd;
    }

    public String getObsrvdAgntCd() {
        return obsrvdAgntCd;
    }

    public String getEntityPrdbCd() {
        return entityPrdbCd;
    }

    public String getCntrctId() {
        return cntrctId;
    }

    public String getInstrmntId() {
        return instrmntId;
    }

    public String getEnttyRl() {
        return enttyRl;
    }
}
