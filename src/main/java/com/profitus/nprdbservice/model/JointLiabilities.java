package com.profitus.nprdbservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JointLiabilities extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reportId;
    private String rprtngAgnCd;
    private String obsrvdAgntCd;
    private String enttyPrdbCd;
    private String cntrctId;
    private String instrmntId;
    private String jntLbltyAmnt;

    public JointLiabilities() {
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

    public String getRprtngAgnCdXML() {
        if(rprtngAgnCd != null) {
            return "RPRTNG_AGNT_CD=\""+rprtngAgnCd+"\"";
        } else {
            return "";
        }
    }

    public void setRprtngAgnCd(String rprtngAgnCd) {
        this.rprtngAgnCd = rprtngAgnCd;
    }

    public String getObsrvdAgntCdXML() {
        if(obsrvdAgntCd != null) {
            return "OBSRVD_AGNT_CD=\""+rprtngAgnCd+"\"";
        } else {
            return "";
        }
    }

    public void setObsrvdAgntCd(String obsrvdAgntCd) {
        this.obsrvdAgntCd = obsrvdAgntCd;
    }

    public String getEnttyPrdbCdXML() {
        if(enttyPrdbCd != null) {
            return "ENTTY_PRDB_CD=\""+enttyPrdbCd+"\"";
        } else {
            return "";
        }
    }

    public void setEnttyPrdbCd(String enttyPrdbCd) {
        this.enttyPrdbCd = enttyPrdbCd;
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

    public String getJntLbltyAmntXML() {
        if(jntLbltyAmnt != null) {
            return "JNT_LBLTY_AMNT=\""+jntLbltyAmnt+"\"";
        } else {
            return "";
        }
    }

    public void setJntLbltyAmnt(String jntLbltyAmnt) {
        this.jntLbltyAmnt = jntLbltyAmnt;
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

    public String getCntrctId() {
        return cntrctId;
    }

    public String getInstrmntId() {
        return instrmntId;
    }

    public String getJntLbltyAmnt() {
        return jntLbltyAmnt;
    }

}
