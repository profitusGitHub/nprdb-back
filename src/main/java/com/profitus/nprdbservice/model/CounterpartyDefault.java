package com.profitus.nprdbservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CounterpartyDefault extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reportId;
    private String rprtngAgnCd;
    private String obsrvdAgntCd;
    private String enttyPrdbCd;
    private String dfltStts;

    public CounterpartyDefault() {
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
        if(rprtngAgnCd != null) {
            return "RPRTNG_AGNT_CD=\""+rprtngAgnCd+"\"";
        } else {
            return "";
        }
    }

    public void setRprtngAgnCd(String rprtngAgnCd) {
        this.rprtngAgnCd = rprtngAgnCd;
    }

    public String getObsrvAgntCdXML() {
        if(obsrvdAgntCd != null) {
            return "OBSRVD_AGNT_CD=\""+obsrvdAgntCd+"\"";
        } else {
            return "";
        }
    }
    public void setObsrvdAgntCd(String obsrvdAgntCd) {
        this.obsrvdAgntCd = obsrvdAgntCd;
    }

    public String getEnttyPrdbCdXML() {
        if(obsrvdAgntCd != null) {
            return "ENTTY_PRDB_CD=\""+obsrvdAgntCd+"\"";
        } else {
            return "";
        }
    }

    public void setEnttyPrdbCd(String enttyPrdbCd) {
        this.enttyPrdbCd = enttyPrdbCd;
    }

    public String getDfltSttsXML() {
        if(dfltStts != null) {
            return "DFLT_STTS=\""+dfltStts+"\"";
        } else {
            return "";
        }
    }

    public void setDfltStts(String dfltStts) {
        this.dfltStts = dfltStts;
    }

    public String getRprtngAgnCd() {
        return rprtngAgnCd;
    }

    public String getObsrvdAgntCd() {
        return obsrvdAgntCd;
    }

    public String getEnttyPrdbCd() {
        return enttyPrdbCd;
    }

    public String getDfltStts() {
        return dfltStts;
    }
}
