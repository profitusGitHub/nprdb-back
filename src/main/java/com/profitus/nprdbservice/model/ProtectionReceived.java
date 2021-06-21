package com.profitus.nprdbservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProtectionReceived extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reportId;
    private String rprtngAgnCd;
    private String obsrvdAgntCd;
    private String prtctnId;
    private String unqPrprtNmbrPrtctn;
    private String isinCdPrtctn;
    private String typPrtctn;
    private String prtctnVl;
    private String typPrtctnVl;
    private String prtctnVltnApprch;
    private String iso3166NutsDsjnt;
    private String dtMtrtyPrtctn;
    private String orgnlPrtctnVl;
    private String prprtValuerId;
    private String addInfClltrl;

    public ProtectionReceived() {
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

    public String getPrtctnIdXML() {
        if(prtctnId != null) {
            return "PRTCTN_ID=\""+prtctnId+"\"";
        } else {
            return "";
        }
    }

    public void setPrtctnId(String prtctnId) {
        this.prtctnId = prtctnId;
    }

    public String getUnqPrprtNmbrPrtctnXML() {
        if(unqPrprtNmbrPrtctn != null) {
            return "UNQ_PRPRT_NMBR_PRTCTN=\""+unqPrprtNmbrPrtctn+"\"";
        } else {
            return "";
        }
    }

    public void setUnqPrprtNmbrPrtctn(String unqPrprtNmbrPrtctn) {
        this.unqPrprtNmbrPrtctn = unqPrprtNmbrPrtctn;
    }

    public String getIsinCdPrtctnXML() {
        if(isinCdPrtctn != null) {
            return "ISIN_CD_PRTCTN=\""+isinCdPrtctn+"\"";
        } else {
            return "";
        }
    }

    public void setIsinCdPrtctn(String isinCdPrtctn) {
        this.isinCdPrtctn = isinCdPrtctn;
    }

    public String getTypPrtctnXML() {
        if(typPrtctn != null) {
            return "TYP_PRTCTN=\""+typPrtctn+"\"";
        } else {
            return "";
        }
    }

    public void setTypPrtctn(String typPrtctn) {
        this.typPrtctn = typPrtctn;
    }

    public String getPrtctnVlXML() {
        if(prtctnVl != null) {
            return "PRTCTN_VL=\""+prtctnVl+"\"";
        } else {
            return "";
        }
    }

    public void setPrtctnVl(String prtctnVl) {
        this.prtctnVl = prtctnVl;
    }

    public String getTypPrtctnVlXML() {
        if(typPrtctnVl != null) {
            return "TYP_PRTCTN_VL=\""+typPrtctnVl+"\"";
        } else {
            return "";
        }
    }

    public void setTypPrtctnVl(String typPrtctnVl) {
        this.typPrtctnVl = typPrtctnVl;
    }

    public String getPrtctnVltnApprchXML() {
        if(prtctnVltnApprch != null) {
            return "PRTCTN_VLTN_APPRCH=\""+prtctnVltnApprch+"\"";
        } else {
            return "";
        }
    }

    public void setPrtctnVltnApprch(String prtctnVltnApprch) {
        this.prtctnVltnApprch = prtctnVltnApprch;
    }

    public String getIso3166NutsDsjntXML() {
        if(iso3166NutsDsjnt != null) {
            return "ISO3166_NUTS_DSJNT=\""+iso3166NutsDsjnt+"\"";
        } else {
            return "";
        }
    }

    public void setIso3166NutsDsjnt(String iso3166NutsDsjnt) {
        this.iso3166NutsDsjnt = iso3166NutsDsjnt;
    }

    public String getDtMtrtyPrtctnXML() {
        if(dtMtrtyPrtctn != null) {
            return "DT_MTRTY_PRTCTN=\""+dtMtrtyPrtctn+"\"";
        } else {
            return "";
        }
    }

    public void setDtMtrtyPrtctn(String dtMtrtyPrtctn) {
        this.dtMtrtyPrtctn = dtMtrtyPrtctn;
    }

    public String getOrgnlPrtctnVlXML() {
        if(orgnlPrtctnVl != null) {
            return "ORGNL_PRTCTN_VL=\""+orgnlPrtctnVl+"\"";
        } else {
            return "";
        }
    }

    public void setOrgnlPrtctnVl(String orgnlPrtctnVl) {
        this.orgnlPrtctnVl = orgnlPrtctnVl;
    }

    public String getPrprtValuerIdXML() {
        if(prprtValuerId != null) {
            return "PRPRT_VALUER_ID=\""+prprtValuerId+"\"";
        } else {
            return "";
        }
    }

    public void setPrprtValuerId(String prprtValuerId) {
        this.prprtValuerId = prprtValuerId;
    }

    public String getAddInfClltrlXML() {
        if(addInfClltrl != null) {
            return "ADD_INF_CLLTRL=\""+addInfClltrl+"\"";
        } else {
            return "";
        }
    }

    public void setAddInfClltrl(String addInfClltrl) {
        this.addInfClltrl = addInfClltrl;
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

    public String getUnqPrprtNmbrPrtctn() {
        return unqPrprtNmbrPrtctn;
    }

    public String getIsinCdPrtctn() {
        return isinCdPrtctn;
    }

    public String getTypPrtctn() {
        return typPrtctn;
    }

    public String getPrtctnVl() {
        return prtctnVl;
    }

    public String getTypPrtctnVl() {
        return typPrtctnVl;
    }

    public String getPrtctnVltnApprch() {
        return prtctnVltnApprch;
    }

    public String getIso3166NutsDsjnt() {
        return iso3166NutsDsjnt;
    }

    public String getDtMtrtyPrtctn() {
        return dtMtrtyPrtctn;
    }

    public String getOrgnlPrtctnVl() {
        return orgnlPrtctnVl;
    }

    public String getPrprtValuerId() {
        return prprtValuerId;
    }

    public String getAddInfClltrl() {
        return addInfClltrl;
    }


}
