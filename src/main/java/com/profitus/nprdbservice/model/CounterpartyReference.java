package com.profitus.nprdbservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CounterpartyReference extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reportId;
    private String rprtngAgnCd;
    private String entityPrdbCd;
    private String lei;
    private String typNtlId;
    private String dscrptnOntnlId;
    private String ntnlId;
    private String typEntity;
    private String nmEntity;
    private String strt;
    private String cty;
    private String pstlCd;
    private String cntry;
    private String lglFrm;
    private String instttnlSctr;
    private String ecnmcActvty;
    private String lglPrcdngStts;

    public CounterpartyReference() {
    }

    public CounterpartyReference(Long id) {
        this.id = id;
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

    public String getRprtngAgnCd() {
        return rprtngAgnCd;
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

    public String getEntityPrdbCd() {
        return entityPrdbCd;
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

    public String getLei() {
        return lei;
    }

    public void setLei(String lei) {
        this.lei = lei;
    }

    public String getTypNtlId() {
        return typNtlId;
    }

    public String getTypNtlIdXML() {
        if(typNtlId != null) {
            return "TYP_NTNL_ID=\""+typNtlId+"\"";
        } else {
            return "";
        }
    }

    public void setTypNtlId(String typNtlId) {
        this.typNtlId = typNtlId;
    }

    public String getDscrptnOntnlId() {
        return dscrptnOntnlId;
    }

    public void setDscrptnOntnlId(String dscrptnOntnlId) {
        this.dscrptnOntnlId = dscrptnOntnlId;
    }

    public String getNtnlId() {
        return ntnlId;
    }

    public String getNtnlIdXML() {
        if(ntnlId != null) {
            return "NTNL_ID=\""+ntnlId+"\"";
        } else {
            return "";
        }
    }

    public void setNtnlId(String ntnlId) {
        this.ntnlId = ntnlId;
    }

    public String getTypEntity() {
        return typEntity;
    }

    public void setTypEntity(String typEntity) {
        this.typEntity = typEntity;
    }

    public String getNmEntity() {
        return nmEntity;
    }

    public String getNmEntityXML() {
        if(nmEntity != null){
            return "NM_ENTTY=\""+nmEntity.replace("„", "'").replace("\"", "'")+"\"";
        } else {
            return "";
        }
    }

    public void setNmEntity(String nmEntity) {
        this.nmEntity = nmEntity;
    }

    public String getStrt() {
        return strt;
    }

    public String getStrtXML() {
        if(strt != null) {
            return "STRT=\""+strt+"\"";
        } else {
            return "";
        }
    }

    public void setStrt(String strt) {
        this.strt = strt;
    }

    public String getCty() {
        return cty;
    }

    public String getCtyXML() {
        if(cty != null) {
            return "CTY=\""+cty+"\"";
        } else {
            return "";
        }
    }

    public void setCty(String cty) {
        this.cty = cty;
    }

    public String getPstlCd() {
        return pstlCd;
    }

    public String getPstlCdXML() {
        if(pstlCd != null) {
            return "PSTL_CD=\""+pstlCd+"\"";
        } else {
            return "";
        }
    }

    public void setPstlCd(String pstlCd) {
        this.pstlCd = pstlCd;
    }

    public String getCntry() {
        return cntry;
    }

    public String getCntryXML() {
        if(cntry != null) {
            return "CNTRY=\""+cntry+"\"";
        } else {
            return "";
        }
    }

    public void setCntry(String cntry) {
        this.cntry = cntry;
    }

    public String getLglFrm() {
        return lglFrm;
    }

    public String getLglFrmXML() {
        if(lglFrm != null) {
            return "LGL_FRM=\""+lglFrm+"\"";
        } else {
            return "";
        }
    }

    public void setLglFrm(String lglFrm) {
        this.lglFrm = lglFrm;
    }

    public String getInstttnlSctr() {
        return instttnlSctr;
    }

    public String getInstttnlSctrXML() {
        if(instttnlSctr != null) {
            return "INSTTTNL_SCTR=\""+instttnlSctr+"\"";
        } else {
            return "";
        }
    }

    public void setInstttnlSctr(String instttnlSctr) {
        this.instttnlSctr = instttnlSctr;
    }

    public String getEcnmcActvty() {
        return ecnmcActvty;
    }

    public String getEcnmcActvtyXML() {
        if(ecnmcActvty != null) {
            return "ECNMC_ACTVTY=\""+ecnmcActvty+"\"";
        } else {
            return "";
        }
    }

    public void setEcnmcActvty(String ecnmcActvty) {
        this.ecnmcActvty = ecnmcActvty;
    }

    public String getLglPrcdngSttsXML() {
        if(lglPrcdngStts != null) {
            return "LGL_PRCDNG_STTS=\""+lglPrcdngStts+"\"";
        } else {
            return "";
        }
    }

    public String getLglPrcdngStts() {
        return lglPrcdngStts;
    }

    public void setLglPrcdngStts(String lglPrcdngStts) {
        this.lglPrcdngStts = lglPrcdngStts;
    }
}
