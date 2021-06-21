package com.profitus.nprdbservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProtectionReceivedProtectionProviders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reportId;
    private String rprtngAgnCd;
    private String obsrvdAgntCd;
    private String prtctnId;
    private String prtctnPrvdrCd;
    private String prmrPrtctnPrvdr;

    public ProtectionReceivedProtectionProviders() {
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

    public String getObsrvAgntCdXML() {
        if(obsrvdAgntCd != null) {
            return "OBSRVD_AGNT_CD=\""+obsrvdAgntCd+"\"";
        } else {
            return "";
        }
    }

    public String getPrtctnIdXM() {
        if(prtctnId != null) {
            return "PRTCTN_ID=\""+prtctnId+"\"";
        } else {
            return "";
        }
    }

    public String getPrtctnPrvdrCdXML() {
        if(prtctnPrvdrCd != null) {
            return "PRTCTN_PRVDR_CD=\""+prtctnPrvdrCd+"\"";
        } else {
            return "";
        }
    }

    public String getPrmrPrtctnPrvdrXML() {
        if(prmrPrtctnPrvdr != null) {
            return "PRMR_PRTCTN_PRVDR=\""+prmrPrtctnPrvdr+"\"";
        } else {
            return "";
        }
    }

    public void setRprtngAgnCd(String rprtngAgnCd) {
        this.rprtngAgnCd = rprtngAgnCd;
    }

    public void setObsrvdAgntCd(String obsrvdAgntCd) {
        this.obsrvdAgntCd = obsrvdAgntCd;
    }

    public void setPrtctnId(String prtctnId) {
        this.prtctnId = prtctnId;
    }

    public void setPrtctnPrvdrCd(String prtctnPrvdrCd) {
        this.prtctnPrvdrCd = prtctnPrvdrCd;
    }

    public void setPrmrPrtctnPrvdr(String prmrPrtctnPrvdr) {
        this.prmrPrtctnPrvdr = prmrPrtctnPrvdr;
    }

    public String getRprtngAgnCd() {
        return rprtngAgnCd;
    }

    public String getObsrvdAgntCd() {
        return obsrvdAgntCd;
    }

    public String getPrtctnId() {
        return prtctnId;
    }

    public String getPrtctnPrvdrCd() {
        return prtctnPrvdrCd;
    }

    public String getPrmrPrtctnPrvdr() {
        return prmrPrtctnPrvdr;
    }
}
