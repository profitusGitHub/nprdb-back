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
class InstrumentGenerator {
    @Autowired
    private lateinit var protectionReceivedRepository: ProtectionReceivedRepository
    @Autowired
    private lateinit var instrumentProtectionRepository: InstrumentProtectionRepository
    @Autowired
    private lateinit var counterpartyDefaultRepository: CounterpartyDefaultRepository
    @Autowired
    private lateinit var protectionReceivedProtectionProvidersRepository: ProtectionReceivedProtectionProvidersRepository


    @Autowired
    private lateinit var msgIdRepository: MessageIdRepository
    private val msgIdPrefix: String = "PRFTLT";

    fun generate(reportId: String?): File? {
        val protectionReceived = protectionReceivedRepository.findByReportId(reportId)
        val instrumentProtection = instrumentProtectionRepository.findByReportId(reportId)
        val counterpartyDefault = counterpartyDefaultRepository.findByReportId(reportId)
        val protectionReceivedProtectionProviders = protectionReceivedProtectionProvidersRepository.findByReportId(reportId)

        val file = File.createTempFile("test", ".tmp")
        val writer = FileWriter(file)
        writer.write(populateValues(getNextMessageId(),
                protectionReceived,
                instrumentProtection.get(),
                counterpartyDefault.get(),
                protectionReceivedProtectionProviders.get()))

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

    private fun populateValues(msgId: String,
                               protectionReceived : List<ProtectionReceived>,
                               instrumentProtection: InstrumentProtection,
                               counterpartyDefault: CounterpartyDefault,
                               protectionReceivedProtectionProviders: ProtectionReceivedProtectionProviders): String {

        val msgIdTimestamp = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
        val date = DateTimeFormatter.ISO_DATE.format(LocalDate.now())
        val uniqueTimeStamp = System.nanoTime()
        var assets: String= ""
        for (protection in protectionReceived){
            assets = assets.plus("""<Obs ${protection.prtctnIdXML}
						 ${protection.unqPrprtNmbrPrtctnXML}
						 ${protection.typPrtctnXML}
						 ${protection.prtctnVlXML}
						 ${protection.typPrtctnVlXML}
						 ${protection.prtctnVltnApprchXML}
						 ${protection.iso3166NutsDsjntXML}
						 ${protection.dtMtrtyPrtctnXML}
						 ${protection.orgnlPrtctnVlXML}
						 ${protection.prprtValuerIdXML}
						 ${protection.addInfClltrlXML} />""")
        }

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
				<Type>CRDT2</Type>
				<Priority>11</Priority>
				<BusinessArea>Bank</BusinessArea>
			</Header>
			<CRDT2 xmlns:message="http://www.sdmx.org/resources/sdmxml/schemas/v2_1/message" xmlns:data="http://www.sdmx.org/resources/sdmxml/schemas/v2_1/data/structurespecific" xmlns:common="http://www.sdmx.org/resources/sdmxml/schemas/v2_1/common" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:BOL_ANCRDT_T2M="http://www.lb.lt/stattistic/anacredit/BOL_ANCRDT_T2M">
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
					<message:Structure structureID="BOL_ANCRDT_PRTCTN_RCVD_C" namespace="BOL_ANCRDT_PRTCTN_RCVD_C" dimensionAtObservation="AllDimensions">
						<common:Structure>
							<Ref agencyID="BOL" id="BOL_ANCRDT_PRTCTN_RCVD_C"/>
						</common:Structure>
					</message:Structure>
					<message:Structure structureID="BOL_ANCRDT_INSTRMNT_PRTCTN_RCVD_C" namespace="BOL_ANCRDT_INSTRMNT_PRTCTN_RCVD_C" dimensionAtObservation="AllDimensions">
						<common:Structure>
							<Ref agencyID="BOL" id="BOL_ANCRDT_INSTRMNT_PRTCTN_RCVD_C"/>
						</common:Structure>
					</message:Structure>
					<message:Structure structureID="BOL_ANCRDT_ENTTY_DFLT_C" namespace="BOL_ANCRDT_ENTTY_DFLT_C" dimensionAtObservation="AllDimensions">
						<common:Structure>
							<Ref agencyID="BOL" id="BOL_ANCRDT_ENTTY_DFLT_C"/>
						</common:Structure>
					</message:Structure>
					<message:Structure structureID="BOL_PRDB_PRTCTN_RCVD_PRVDS_C" namespace="BOL_PRDB_PRTCTN_RCVD_PRVDS_C" dimensionAtObservation="AllDimensions">
						<common:Structure>
							<Ref agencyID="BOL" id="BOL_PRDB_PRTCTN_RCVD_PRVDS_C"/>
						</common:Structure>
					</message:Structure>
				</message:Header>
				<message:DataSet data:structureRef="BOL_ANCRDT_HDR_C" xsi:type="BOL_ANCRDT_T2M:BOL_ANCRDT_HDR_C" data:dataScope="DataStructure">
					<Obs ${instrumentProtection.rprtngAgnCdXML} 
					     ${instrumentProtection.obsrvdAgnCdXML} 
                        DT_RPRTNG="${date}" 
                        SRVY_ID="BOL_ANCRDT_T2M" 
                        SBMSSN_TYP="FULL_DYNAMIC"/>
				</message:DataSet>
				<message:DataSet data:structureRef="BOL_ANCRDT_PRTCTN_RCVD_C" xsi:type="BOL_ANCRDT_T2M:BOL_ANCRDT_PRTCTN_RCVD_C" data:dataScope="DataStructure" data:action="Replace">
                    ${assets}
				</message:DataSet>
				<message:DataSet data:structureRef="BOL_ANCRDT_INSTRMNT_PRTCTN_RCVD_C" xsi:type="BOL_ANCRDT_T2M:BOL_ANCRDT_INSTRMNT_PRTCTN_RCVD_C" data:dataScope="DataStructure" data:action="Replace">
					<Obs ${instrumentProtection.cntrctIdXML}
						 ${instrumentProtection.instrmntIdXML} 
						 ${instrumentProtection.prtctnIdXML}
						 ${instrumentProtection.prtctnAllctdVlXML}
						 ${instrumentProtection.thrdPrtyPrrtyClmsXML}
						 ${instrumentProtection.rankClltrlXML}
						 ${instrumentProtection.mrtggIdPrtctnXML} />
				</message:DataSet>
				<message:DataSet data:structureRef="BOL_ANCRDT_ENTTY_DFLT_C" xsi:type="BOL_ANCRDT_T2M:BOL_ANCRDT_ENTTY_DFLT_C" data:dataScope="DataStructure" data:action="Replace">
					<Obs ${counterpartyDefault.enttyPrdbCdXML}/>
				</message:DataSet>
				<message:DataSet data:structureRef="BOL_PRDB_PRTCTN_RCVD_PRVDS_C" xsi:type="BOL_ANCRDT_T2M:BOL_PRDB_PRTCTN_RCVD_PRVDS_C" data:dataScope="DataStructure" data:action="Replace">
					<Obs ${protectionReceivedProtectionProviders.prtctnIdXM} 
                         ${protectionReceivedProtectionProviders.prtctnPrvdrCdXML} 
                         ${protectionReceivedProtectionProviders.prmrPrtctnPrvdrXML}/>
				</message:DataSet>
			</CRDT2>
		</Doc>
	</Docs>
</Msg>"""
    }
}
