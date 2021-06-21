package com.profitus.nprdbservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Financial extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reportId;
    private String rprtngAgnCd;
    private String obsrvdAgntCd;
    private String cntrctId;
    private String instrmntId;
    private String dtNxtIntrstRtRst;
    private String appldRt;
    private String trnsfrrdAmnt;
    private String arrrs;
    private String dtPstD;
    private String typScrtstn;
    private String otstndngNmnlAmnt;
    private String typChngOtstndngNmnlAmnt;
    private String amntChngotstndngNmnlAmnt;
    private String offBlncShtAmnt;
    private String finalStatus;

    public Financial() {
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
            return "OBSRVD_AGNT_CD=\""+obsrvdAgntCd+"\"";
        } else {
            return "";
        }
    }

    public void setObsrvdAgntCd(String obsrvdAgntCd) {
        this.obsrvdAgntCd = obsrvdAgntCd;
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

    public String getDtNxtIntrstRtRstXML() {
        if(dtNxtIntrstRtRst != null) {
            return "DT_NXT_INTRST_RT_RST=\""+dtNxtIntrstRtRst+"\"";
        } else {
            return "";
        }
    }

    public void setDtNxtIntrstRtRst(String dtNxtIntrstRtRst) {
        this.dtNxtIntrstRtRst = dtNxtIntrstRtRst;
    }

    public String getAppldRtXML() {
        if(appldRt != null) {
            return "APPLD_RT=\""+appldRt+"\"";
        } else {
            return "";
        }
    }

    public void setAppldRt(String appldRt) {
        this.appldRt = appldRt;
    }

    public String getTrnsfrrdAmntXML() {
        if(trnsfrrdAmnt != null) {
            return "TRNSFRRD_AMNT=\""+trnsfrrdAmnt+"\"";
        } else {
            return "";
        }
    }

    public void setTrnsfrrdAmnt(String trnsfrrdAmnt) {
        this.trnsfrrdAmnt = trnsfrrdAmnt;
    }

    public String getArrrsXML() {
        if(arrrs != null) {
            return "ARRRS=\""+arrrs+"\"";
        } else {
            return "";
        }
    }

    public void setArrrs(String arrrs) {
        this.arrrs = arrrs;
    }

    public String getDtPstDXML() {
        if(dtPstD != null) {
            return "DT_PST_D=\""+dtPstD+"\"";
        } else {
            return "";
        }
    }

    public void setDtPstD(String dtPstD) {
        this.dtPstD = dtPstD;
    }

    public String getTypScrtstnXML() {
        if(typScrtstn != null) {
            return "TYP_SCRTSTN=\""+typScrtstn+"\"";
        } else {
            return "";
        }
    }

    public void setTypScrtstn(String typScrtstn) {
        this.typScrtstn = typScrtstn;
    }

    public String getOtstndngNmnlAmntXML() {
        if(otstndngNmnlAmnt != null) {
            return "OTSTNDNG_NMNL_AMNT=\""+otstndngNmnlAmnt+"\"";
        } else {
            return "";
        }
    }

    public void setOtstndngNmnlAmnt(String otstndngNmnlAmnt) {
        this.otstndngNmnlAmnt = otstndngNmnlAmnt;
    }

    public String getTypChngOtstndngNmnlAmntXML() {
        if(typChngOtstndngNmnlAmnt != null) {
            return "TYP_CHNG_OTSTNDNG_NMNL_AMNT=\""+typChngOtstndngNmnlAmnt+"\"";
        } else {
            return "";
        }
    }

    public void setTypChngOtstndngNmnlAmnt(String typChngOtstndngNmnlAmnt) {
        this.typChngOtstndngNmnlAmnt = typChngOtstndngNmnlAmnt;
    }

    public String getAmntChngotstndngNmnlAmntXML() {
        if(amntChngotstndngNmnlAmnt != null) {
            return "AMNT_CHNG_OTSTNDNG_NMNL_AMNT=\""+amntChngotstndngNmnlAmnt+"\"";
        } else {
            return "";
        }
    }

    public void setAmntChngotstndngNmnlAmnt(String amntChngotstndngNmnlAmnt) {
        this.amntChngotstndngNmnlAmnt = amntChngotstndngNmnlAmnt;
    }

    public String getOffBlncShtAmntXML() {
        if(offBlncShtAmnt != null) {
            return "OFF_BLNC_SHT_AMNT=\""+offBlncShtAmnt+"\"";
        } else {
            return "";
        }
    }

    public void setOffBlncShtAmnt(String offBlncShtAmnt) {
        this.offBlncShtAmnt = offBlncShtAmnt;
    }

    public String getFinalStatusXML() {
        if(finalStatus != null) {
            return "FINAL_STATUS=\""+finalStatus+"\"";
        } else {
            return "";
        }
    }

    public void setFinalStatus(String finalStatus) {
        this.finalStatus = finalStatus;
    }

    public String getRprtngAgnCd() {
        return rprtngAgnCd;
    }

    public String getObsrvdAgntCd() {
        return obsrvdAgntCd;
    }

    public String getCntrctId() {
        return cntrctId;
    }

    public String getInstrmntId() {
        return instrmntId;
    }

    public String getDtNxtIntrstRtRst() {
        return dtNxtIntrstRtRst;
    }

    public String getAppldRt() {
        return appldRt;
    }

    public String getTrnsfrrdAmnt() {
        return trnsfrrdAmnt;
    }

    public String getArrrs() {
        return arrrs;
    }

    public String getDtPstD() {
        return dtPstD;
    }

    public String getTypScrtstn() {
        return typScrtstn;
    }

    public String getOtstndngNmnlAmnt() {
        return otstndngNmnlAmnt;
    }

    public String getTypChngOtstndngNmnlAmnt() {
        return typChngOtstndngNmnlAmnt;
    }

    public String getAmntChngotstndngNmnlAmnt() {
        return amntChngotstndngNmnlAmnt;
    }

    public String getOffBlncShtAmnt() {
        return offBlncShtAmnt;
    }

    public String getFinalStatus() {
        return finalStatus;
    }
}

