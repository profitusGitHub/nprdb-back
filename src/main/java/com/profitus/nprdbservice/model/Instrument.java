package com.profitus.nprdbservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Instrument extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reportId;
    private String rprtngAgnCd;
    private String obsrvdAgnCd;
    private String cntrctCd;
    private String instrmntId;
    private String typInstrmnt;
    private String typAmrtstn;
    private String iso4217;
    private String dtIncpt;
    private String dtEndIntrstOnly;
    private String intrstRtCp;
    private String intrstRtFlr;
    private String frqncyIntrstRtRst;
    private String intrstRtSprd;
    private String typIntrstRt;
    private String dtLglFnlMtrty;
    private String cmmtmntIncptn;
    private String pymntFrqncy;
    private String prjctFnncLn;
    private String prps;
    private String addInfLoanPrps;
    private String rfrncRtIndx;
    private String rfrncRtMtrt;
    private String dtSttlmnt;
    private String rpymntRghts;
    private String crdPrchId;

    public Instrument() {
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

    public String getObsrvdAgnCdXML() {
        if(rprtngAgnCd != null) {
            return "OBSRVD_AGNT_CD=\""+rprtngAgnCd+"\"";
        } else {
            return "";
        }
    }

    public void setObsrvdAgnCd(String obsrvdAgnCd) {
        this.obsrvdAgnCd = obsrvdAgnCd;
    }

    public String getCntrctCdXML() {
        if(cntrctCd != null) {
            return "CNTRCT_ID=\""+cntrctCd+"\"";
        } else {
            return "";
        }
    }

    public void setCntrctCd(String cntrctCd) {
        this.cntrctCd = cntrctCd;
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

    public String getTypInstrmntXML() {
        if(typInstrmnt != null) {
            return "TYP_INSTRMNT=\""+typInstrmnt+"\"";
        } else {
            return "";
        }
    }

    public void setTypInstrmnt(String typInstrmnt) {
        this.typInstrmnt = typInstrmnt;
    }

    public String getTypAmrtstnXML() {
        if(typAmrtstn != null) {
            return "TYP_AMRTSTN=\""+typAmrtstn+"\"";
        } else {
            return "";
        }
    }

    public void setTypAmrtstn(String typAmrtstn) {
        this.typAmrtstn = typAmrtstn;
    }

    public String getIso4217XML() {
        if(iso4217 != null) {
            return "ISO4217=\""+iso4217+"\"";
        } else {
            return "";
        }
    }

    public void setIso4217(String iso4217) {
        this.iso4217 = iso4217;
    }

    public String getDtIncptXML() {
        if(dtIncpt != null) {
            return "DT_INCPTN=\""+dtIncpt+"\"";
        } else {
            return "";
        }
    }

    public void setDtIncpt(String dtIncpt) {
        this.dtIncpt = dtIncpt;
    }

    public String getDtEndIntrstOnlyXML() {
        if(dtEndIntrstOnly != null) {
            return "CRD_PRCH_ID=\"" + dtEndIntrstOnly + "\"";
        } else {
            return "";
        }
    }

    public void setDtEndIntrstOnly(String dtEndIntrstOnly) {
        this.dtEndIntrstOnly = dtEndIntrstOnly;
    }

    public String getIntrstRtCpXML() {
        if(intrstRtCp != null) {
            return "INTRST_RT_CP=\""+intrstRtCp+"\"";
        } else {
            return "";
        }
    }

    public void setIntrstRtCp(String intrstRtCp) {
        this.intrstRtCp = intrstRtCp;
    }

    public String getIntrstRtFlrXML() {
        if(intrstRtFlr != null) {
            return "INTRST_RT_FLR=\""+intrstRtFlr+"\"";
        } else {
            return "";
        }
    }

    public void setIntrstRtFlr(String intrstRtFlr) {
        this.intrstRtFlr = intrstRtFlr;
    }

    public String getFrqncyIntrstRtRstXML() {
        if(frqncyIntrstRtRst != null) {
            return "FRQNCY_INTRST_RT_RST=\""+frqncyIntrstRtRst+"\"";
        } else {
            return "";
        }
    }

    public void setFrqncyIntrstRtRst(String frqncyIntrstRtRst) {
        this.frqncyIntrstRtRst = frqncyIntrstRtRst;
    }

    public String getIntrstRtSprdXML() {
        if(intrstRtSprd != null) {
            return "INTRST_RT_SPRD=\""+intrstRtSprd+"\"";
        } else {
            return "";
        }
    }

    public void setIntrstRtSprd(String intrstRtSprd) {
        this.intrstRtSprd = intrstRtSprd;
    }

    public String getTypIntrstRtXML() {
        if(typIntrstRt != null) {
            return "TYP_INTRST_RT=\""+typIntrstRt+"\"";
        } else {
            return "";
        }
    }

    public void setTypIntrstRt(String typIntrstRt) {
        this.typIntrstRt = typIntrstRt;
    }

    public String getDtLglFnlMtrtyXML() {
        if(dtLglFnlMtrty != null) {
            return "DT_LGL_FNL_MTRTY=\""+dtLglFnlMtrty+"\"";
        } else {
            return "";
        }
    }

    public void setDtLglFnlMtrty(String dtLglFnlMtrty) {
        this.dtLglFnlMtrty = dtLglFnlMtrty;
    }

    public String getCmmtmntIncptnXML() {
        if(cmmtmntIncptn != null) {
            return "CMMTMNT_INCPTN=\""+cmmtmntIncptn+"\"";
        } else {
            return "";
        }
    }

    public void setCmmtmntIncptn(String cmmtmntIncptn) {
        this.cmmtmntIncptn = cmmtmntIncptn;
    }

    public String getPymntFrqncyXML() {
        if(pymntFrqncy != null) {
            return "PYMNT_FRQNCY=\""+pymntFrqncy+"\"";
        } else {
            return "";
        }
    }

    public void setPymntFrqncy(String pymntFrqncy) {
        this.pymntFrqncy = pymntFrqncy;
    }

    public String getPrjctFnncLnXML() {
        if(prjctFnncLn != null) {
            return "PRJCT_FNNC_LN=\""+prjctFnncLn+"\"";
        } else {
            return "";
        }
    }

    public void setPrjctFnncLn(String prjctFnncLn) {
        this.prjctFnncLn = prjctFnncLn;
    }

    public String getPrpsXML() {
        if(prps != null) {
            return "PRPS=\""+prps+"\"";
        } else {
            return "";
        }
    }

    public void setPrps(String prps) {
        this.prps = prps;
    }

    public String getAddInfLoanPrpsXML() {
        if(addInfLoanPrps != null) {
            return "ADD_INF_LOAN_PRPS=\""+addInfLoanPrps+"\"";
        } else {
            return "";
        }
    }

    public void setAddInfLoanPrps(String addInfLoanPrps) {
        this.addInfLoanPrps = addInfLoanPrps;
    }

    public String getRfrncRtIndxXML() {
        return "RFRNC_RT_INDX=\"NA\"";
    }

    public void setRfrncRtIndx(String rfrncRtIndx) {
        this.rfrncRtIndx = rfrncRtIndx;
    }

    public String getRfrncRtMtrtXML() {
        return "RFRNC_RT_MTRT=\"NA\"";
    }

    public void setRfrncRtMtrt(String rfrncRtMtrt) {
        this.rfrncRtMtrt = rfrncRtMtrt;
    }

    public String getDtSttlmntXML() {
        if(dtSttlmnt != null) {
            return "DT_STTLMNT=\""+dtSttlmnt+"\"";
        } else {
            return "";
        }
    }

    public void setDtSttlmnt(String dtSttlmnt) {
        this.dtSttlmnt = dtSttlmnt;
    }

    public String getRpymntRghtsXML() {
        if(rpymntRghts != null) {
            return "RPYMNT_RGHTS=\""+rpymntRghts+"\"";
        }

        return "RPYMNT_RGHTS=\""+rpymntRghts+"\"";
    }

    public void setRpymntRghts(String rpymntRghts) {
        this.rpymntRghts = rpymntRghts;
    }

    public String getCrdPrchIdXML() {
        if(crdPrchId != null) {
            return "CRD_PRCH_ID=\"" + crdPrchId + "\"";
        } else {
            return "";
        }
    }

    public void setCrdPrchId(String crdPrchId) {
        this.crdPrchId = crdPrchId;
    }

    public String getRprtngAgnCd() {
        return rprtngAgnCd;
    }

    public String getObsrvdAgnCd() {
        return obsrvdAgnCd;
    }

    public String getCntrctCd() {
        return cntrctCd;
    }

    public String getInstrmntId() {
        return instrmntId;
    }

    public String getTypInstrmnt() {
        return typInstrmnt;
    }

    public String getTypAmrtstn() {
        return typAmrtstn;
    }

    public String getIso4217() {
        return iso4217;
    }

    public String getDtIncpt() {
        return dtIncpt;
    }

    public String getDtEndIntrstOnly() {
        return dtEndIntrstOnly;
    }

    public String getIntrstRtCp() {
        return intrstRtCp;
    }

    public String getIntrstRtFlr() {
        return intrstRtFlr;
    }

    public String getFrqncyIntrstRtRst() {
        return frqncyIntrstRtRst;
    }

    public String getIntrstRtSprd() {
        return intrstRtSprd;
    }

    public String getTypIntrstRt() {
        return typIntrstRt;
    }

    public String getDtLglFnlMtrty() {
        return dtLglFnlMtrty;
    }

    public String getCmmtmntIncptn() {
        return cmmtmntIncptn;
    }

    public String getPymntFrqncy() {
        return pymntFrqncy;
    }

    public String getPrjctFnncLn() {
        return prjctFnncLn;
    }

    public String getPrps() {
        return prps;
    }

    public String getAddInfLoanPrps() {
        return addInfLoanPrps;
    }

    public String getRfrncRtIndx() {
        return rfrncRtIndx;
    }

    public String getRfrncRtMtrt() {
        return rfrncRtMtrt;
    }

    public String getDtSttlmnt() {
        return dtSttlmnt;
    }

    public String getRpymntRghts() {
        return rpymntRghts;
    }

    public String getCrdPrchId() {
        return crdPrchId;
    }
}
