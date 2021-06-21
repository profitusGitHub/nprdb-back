package com.profitus.nprdbservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InstrumentProtection extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reportId;
    private String rprtngAgnCd;
    private String obsrvdAgntCd;
    private String cntrctId;
    private String instrmntId;
    private String prtctnId;
    private String prtctnAllctdVl;
    private String thrdPrtyPrrtyClms;
    private String rankClltrl;
    private String mrtggIdPrtctn;

    public InstrumentProtection() {
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

    public String getRprtngAgnCd() {
        return rprtngAgnCd;
    }

    public void setRprtngAgnCd(String rprtngAgnCd) {
        this.rprtngAgnCd = rprtngAgnCd;
    }

    public String getObsrvdAgntCd() {
        return obsrvdAgntCd;
    }

    public void setObsrvdAgntCd(String obsrvdAgntCd) {
        this.obsrvdAgntCd = obsrvdAgntCd;
    }

    public String getCntrctId() {
        return cntrctId;
    }

    public void setCntrctId(String cntrctId) {
        this.cntrctId = cntrctId;
    }

    public String getInstrmntId() {
        return instrmntId;
    }

    public void setInstrmntId(String instrmntId) {
        this.instrmntId = instrmntId;
    }

    public String getPrtctnId() {
        return prtctnId;
    }

    public void setPrtctnId(String prtctnId) {
        this.prtctnId = prtctnId;
    }

    public String getPrtctnAllctdVl() {
        return prtctnAllctdVl;
    }

    public void setPrtctnAllctdVl(String prtctnAllctdVl) {
        this.prtctnAllctdVl = prtctnAllctdVl;
    }

    public String getThrdPrtyPrrtyClms() {
        return thrdPrtyPrrtyClms;
    }

    public void setThrdPrtyPrrtyClms(String thrdPrtyPrrtyClms) {
        this.thrdPrtyPrrtyClms = thrdPrtyPrrtyClms;
    }

    public String getRankClltrl() {
        return rankClltrl;
    }

    public void setRankClltrl(String rankClltrl) {
        this.rankClltrl = rankClltrl;
    }

    public String getMrtggIdPrtctn() {
        return mrtggIdPrtctn;
    }

    public void setMrtggIdPrtctn(String mrtggIdPrtctn) {
        this.mrtggIdPrtctn = mrtggIdPrtctn;
    }

    public String getObsrvdAgnCdXML() {
        if(rprtngAgnCd != null) {
            return "OBSRVD_AGNT_CD=\""+rprtngAgnCd+"\"";
        } else {
            return "";
        }
    }

    public String getCntrctIdXML() {
        if(cntrctId != null) {
            return "CNTRCT_ID=\""+cntrctId+"\"";
        } else {
            return "";
        }
    }

    public String getInstrmntIdXML() {
        if(instrmntId != null) {
            return "INSTRMNT_ID=\""+instrmntId+"\"";
        } else {
            return "";
        }
    }

    public String getPrtctnIdXML() {
        if(prtctnId != null) {
            return "PRTCTN_ID=\""+prtctnId+"\"";
        } else {
            return "";
        }
    }

    public String getPrtctnAllctdVlXML() {
        if(prtctnAllctdVl != null) {
            return "PRTCTN_ALLCTD_VL=\""+prtctnAllctdVl+"\"";
        } else {
            return "";
        }
    }

    public String getThrdPrtyPrrtyClmsXML() {
        if(thrdPrtyPrrtyClms != null) {
            return "THRD_PRTY_PRRTY_CLMS=\""+thrdPrtyPrrtyClms+"\"";
        } else {
            return "";
        }
    }

    public String getRankClltrlXML() {
        if(rankClltrl != null) {
            return "RANK_CLLTRL=\""+rankClltrl+"\"";
        } else {
            return "";
        }
    }

    public String getMrtggIdPrtctnXML() {
        if(mrtggIdPrtctn != null) {
            return "MRTGG_ID_PRTCTN=\""+mrtggIdPrtctn+"\"";
        } else {
            return "";
        }
    }

}
