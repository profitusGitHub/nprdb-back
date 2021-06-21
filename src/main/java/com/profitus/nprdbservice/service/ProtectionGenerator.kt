package com.profitus.nprdbservice.service

import com.profitus.nprdbservice.model.*
import com.profitus.nprdbservice.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

@Service
class ProtectionGenerator {
    @Autowired
    private lateinit var instrumentRepository: InstrumentRepository
    @Autowired
    private lateinit var financialRepository: FinancialRepository
    @Autowired
    private lateinit var counterpartyInstrumentRepository: CounterpartyInstrumentRepository
    @Autowired
    private lateinit var jointLiabilitiesRepository: JointLiabilitiesRepository


    @Autowired
    private lateinit var msgIdRepository: MessageIdRepository
    private val msgIdPrefix: String = "PRFTLT";

    fun generate(reportId: String?): File? {
        val instrument = instrumentRepository.findByReportId(reportId)
        val financial = financialRepository.findByReportId(reportId)
        val counterpartyInstrument = counterpartyInstrumentRepository.findByReportId(reportId)
        val jointLiabilities = jointLiabilitiesRepository.findByReportId(reportId)

        val file = File.createTempFile("test", ".tmp")
        val writer = FileWriter(file)
        writer.write(populateValues(getNextMessageId(),
                instrument.get(),
                financial.get(),
                counterpartyInstrument.get(),
                jointLiabilities.get()))
        writer.close()
        val reader = BufferedReader(FileReader(file))
        reader.close()
        return file
    }

    private fun getNextMessageId(): String {
        var nextId = ""
        val msgIdEntity= msgIdRepository.findFirstBy()
        if(msgIdEntity.isPresent){
            val msgId = msgIdEntity.get()
            nextId = msgId.nextId.toString()
            msgId.increse()
            msgIdRepository.save(msgId)
        } else {
            msgIdRepository.save(MessageId(1L))
        }

        return msgIdPrefix+nextId
    }

    private fun populateValues(msgId: String, instrument: Instrument,
                               financial: Financial,
                               counterpartyInstrument: CounterpartyInstrument,
                               jointLiabilities: JointLiabilities): String {
        val msgIdTimestamp = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
        val date = DateTimeFormatter.ISO_DATE.format(LocalDate.now())
        val uniqueTimeStamp = System.nanoTime()

        return """<Msg ID="Edoc" Type="CRDQUE" Version="2017-1-0">
	<Header>
		<Sender>PRFTLT22XXX</Sender>
		<Receiver>LIABLT2XMSD</Receiver>
		<Priority>11</Priority>
		<MsgId>${uniqueTimeStamp}</MsgId>
		<Date>${msgIdTimestamp}</Date>
		<System>PRDB</System>
	</Header>
	<Docs>
		<Doc>
			<Header>
				<DocId>${uniqueTimeStamp}</DocId>
				<Dates>
					<Type>FormDoc</Type>
					<Date>${msgIdTimestamp}</Date>
				</Dates>
				<Type>CRDT1</Type>
				<Priority>11</Priority>
				<BusinessArea>Bank</BusinessArea>
			</Header>
			<CRDT1 xmlns:message="http://www.sdmx.org/resources/sdmxml/schemas/v2_1/message" 
			xmlns:data="http://www.sdmx.org/resources/sdmxml/schemas/v2_1/data/structurespecific" 
			xmlns:common="http://www.sdmx.org/resources/sdmxml/schemas/v2_1/common" 
			xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
			xmlns:BOL_ANCRDT_T1M="http://www.lb.lt/stattistic/anacredit/BOL_ANCRDT_T1M">
				<message:Header>
					<message:ID>${msgId}</message:ID>
					<message:Test>false</message:Test>
					<message:Prepared>${msgIdTimestamp}</message:Prepared>
					<message:Sender id="PRFTLT22XXX"/>
					<message:Receiver id="LIABLT2XMSD"/>	
					<message:Structure structureID="BOL_ANCRDT_HDR_C" namespace="BOL_ANCRDT_HDR_C" dimensionAtObservation="AllDimensions">
						<common:Structure>
							<Ref agencyID="BOL" id="BOL_ANCRDT_HDR_C"/>
						</common:Structure>
					</message:Structure>
					<message:Structure structureID="BOL_ANCRDT_INSTRMNT_C" namespace="BOL_ANCRDT_INSTRMNT_C" dimensionAtObservation="AllDimensions">
						<common:Structure>
							<Ref agencyID="BOL" id="BOL_ANCRDT_INSTRMNT_C"/>
						</common:Structure>
					</message:Structure>
					<message:Structure structureID="BOL_ANCRDT_JNT_LBLTS_C" namespace="BOL_ANCRDT_JNT_LBLTS_C" dimensionAtObservation="AllDimensions">
						<common:Structure>
							<Ref agencyID="BOL" id="BOL_ANCRDT_JNT_LBLTS_C"/>
						</common:Structure>
					</message:Structure>
					<message:Structure structureID="BOL_ANCRDT_FNNCL_C" namespace="BOL_ANCRDT_FNNCL_C" dimensionAtObservation="AllDimensions">
						<common:Structure>
							<Ref agencyID="BOL" id="BOL_ANCRDT_FNNCL_C"/>
						</common:Structure>
					</message:Structure>
					<message:Structure structureID="BOL_ANCRDT_ENTTY_INSTRMNT_C" namespace="BOL_ANCRDT_ENTTY_INSTRMNT_C" dimensionAtObservation="AllDimensions">
						<common:Structure>
							<Ref agencyID="BOL" id="BOL_ANCRDT_ENTTY_INSTRMNT_C"/>
						</common:Structure>
					</message:Structure>
				</message:Header>
				<message:DataSet data:structureRef="BOL_ANCRDT_HDR_C" xsi:type="BOL_ANCRDT_T1M:BOL_ANCRDT_HDR_C" data:dataScope="DataStructure">
					<Obs ${instrument.rprtngAgnCdXML}
					     ${instrument.obsrvdAgnCdXML} 					
					SRVY_ID="BOL_ANCRDT_T1M"
					DT_RPRTNG="${date}" 
					SBMSSN_TYP="FULL_DYNAMIC"/>
				</message:DataSet>
				<message:DataSet data:structureRef="BOL_ANCRDT_INSTRMNT_C" xsi:type="BOL_ANCRDT_T1M:BOL_ANCRDT_INSTRMNT_C" data:dataScope="DataStructure" data:action="Replace">
					<Obs 
                    ${instrument.cntrctCdXML?.toString()}
                    ${instrument.instrmntIdXML?.toString()}
                    ${instrument.typInstrmntXML?.toString()}
                    ${instrument.typAmrtstnXML?.toString()}
                    ${instrument.iso4217XML?.toString()}
                    ${instrument.dtIncptXML?.toString()}
                    ${instrument.dtEndIntrstOnlyXML?.toString()}
                    ${instrument.intrstRtCpXML?.toString()}
                    ${instrument.intrstRtFlrXML?.toString()}
                    ${instrument.frqncyIntrstRtRstXML?.toString()}
                    ${instrument.intrstRtSprdXML?.toString()}
                    ${instrument.typIntrstRtXML?.toString()}
                    ${instrument.dtLglFnlMtrtyXML?.toString()}
                    ${instrument.cmmtmntIncptnXML?.toString()}
                    ${instrument.pymntFrqncyXML?.toString()}
                    ${instrument.prjctFnncLnXML?.toString()}
                    ${instrument.prpsXML?.toString()}
                    ${instrument.addInfLoanPrpsXML?.toString()}
                    ${instrument.rfrncRtIndxXML?.toString()}
                    ${instrument.rfrncRtMtrtXML?.toString()}
                    ${instrument.dtSttlmntXML}
                    ${instrument.rpymntRghtsXML}
                    ${instrument.crdPrchIdXML} />
				</message:DataSet>
				<message:DataSet data:structureRef="BOL_ANCRDT_FNNCL_C" xsi:type="BOL_ANCRDT_T1M:BOL_ANCRDT_FNNCL_C" data:dataScope="DataStructure" data:action="Replace">
					<Obs ${financial.cntrctIdXML}
                         ${financial.instrmntIdXML}
                         ${financial.dtNxtIntrstRtRstXML}
                         ${financial.appldRtXML}
                         ${financial.trnsfrrdAmntXML}
                         ${financial.arrrsXML}
                         ${financial.dtPstDXML}
                         ${financial.typScrtstnXML}
                         ${financial.otstndngNmnlAmntXML}
                         ${financial.typChngOtstndngNmnlAmntXML}
                         ${financial.amntChngotstndngNmnlAmntXML}
                         ${financial.offBlncShtAmntXML}
                         ${financial.finalStatusXML} />
				</message:DataSet>
				<message:DataSet data:structureRef="BOL_ANCRDT_JNT_LBLTS_C" xsi:type="BOL_ANCRDT_T1M:BOL_ANCRDT_JNT_LBLTS_C" data:dataScope="DataStructure" data:action="Replace">
					<Obs ${jointLiabilities.enttyPrdbCdXML}
                         ${jointLiabilities.cntrctIdXML}
                         ${jointLiabilities.instrmntIdXML}
                         ${jointLiabilities.jntLbltyAmntXML} />
				</message:DataSet>
				<message:DataSet data:structureRef="BOL_ANCRDT_ENTTY_INSTRMNT_C" xsi:type="BOL_ANCRDT_T1M:BOL_ANCRDT_ENTTY_INSTRMNT_C" data:dataScope="DataStructure" data:action="Replace">
					<Obs ${counterpartyInstrument.entityPrdbCdXML}
                         ${counterpartyInstrument.cntrctIdXML}
                         ${counterpartyInstrument.instrmntIdXML}
                         ${counterpartyInstrument.enttyRlXML} />
				</message:DataSet>		
			</CRDT1>
		</Doc>
	</Docs>
</Msg>"""
    }





}
