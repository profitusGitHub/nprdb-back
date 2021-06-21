package com.profitus.nprdbservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Accounting extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reportId;
    private String rprtngAgnCd;
    private String obsrvAgntCd;
    private String entityPrdbCd;
    private String cntrctId;
    private String instrmntId;
    private String accmltdWrtffsPrncpl;
    private String accmltdWrtffsIntrst;
    private String frbrncStts;

    public Accounting() {
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
        if(rprtngAgnCd != null) {
            return "OBSRVD_AGNT_CD=\""+rprtngAgnCd+"\"";
        } else {
            return "";
        }
    }

    public void setObsrvAgntCd(String obsrvAgntCd) {
        this.obsrvAgntCd = obsrvAgntCd;
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

    public String getAccmltdWrtffsPrncplXML() {
        if(accmltdWrtffsPrncpl != null) {
            return "ACCMLTD_WRTFFS_PRNCPL=\""+accmltdWrtffsPrncpl+"\"";
        } else {
            return "";
        }
    }

    public void setAccmltdWrtffsPrncpl(String accmltdWrtffsPrncpl) {
        this.accmltdWrtffsPrncpl = accmltdWrtffsPrncpl;
    }

    public String getAccmltdWrtffsIntrstXML() {
        if(accmltdWrtffsIntrst != null) {
            return "ACCMLTD_WRTFFS_INTRST=\""+accmltdWrtffsIntrst+"\"";
        } else {
            return "";
        }
    }

    public void setAccmltdWrtffsIntrst(String accmltdWrtffsIntrst) {
        this.accmltdWrtffsIntrst = accmltdWrtffsIntrst;
    }

    public String getFrbrncSttsXML() {
        if(frbrncStts != null) {
            return "FRBRNC_STTS=\""+frbrncStts+"\"";
        } else {
            return "";
        }
    }

    public void setFrbrncStts(String frbrncStts) {
        this.frbrncStts = frbrncStts;
    }

    public String getRprtngAgnCd() {
        return rprtngAgnCd;
    }

    public String getObsrvAgntCd() {
        return obsrvAgntCd;
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

    public String getAccmltdWrtffsPrncpl() {
        return accmltdWrtffsPrncpl;
    }

    public String getAccmltdWrtffsIntrst() {
        return accmltdWrtffsIntrst;
    }

    public String getFrbrncStts() {
        return frbrncStts;
    }
}
