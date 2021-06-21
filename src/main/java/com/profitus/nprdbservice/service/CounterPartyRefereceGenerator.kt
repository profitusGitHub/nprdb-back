package com.profitus.nprdbservice.service

import com.profitus.nprdbservice.model.CounterpartyReference
import com.profitus.nprdbservice.model.MessageId
import com.profitus.nprdbservice.repository.CounterpartyReferenceRepository
import com.profitus.nprdbservice.repository.MessageIdRepository
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
class CounterPartyRefereceGenerator {
    @Autowired
    private lateinit var repository: CounterpartyReferenceRepository
    @Autowired
    private lateinit var msgIdRepository: MessageIdRepository
    private val msgIdPrefix: String = "PRFTLT";

    fun generate(reportId: String?): File? {
        val reportEntity = repository.findByReportId(reportId)

        val file = File.createTempFile("test", ".tmp")
        val writer = FileWriter(file)
        writer.write(populateValues(reportEntity.get(), getNextMessageId()))
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

    private fun populateValues(data: CounterpartyReference, msgId: String): String {
        val msgIdTimestamp = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
        val date = DateTimeFormatter.ISO_DATE.format(LocalDate.now())
        val uniqueTimeStamp = System.nanoTime()

        return """<Msg ID="Edoc" Type="CRDCTP" Version="2017-1-0">
	<Header>
		<Sender>PRFTLT22XXX</Sender>
		<Receiver>LIABLT2XMSD</Receiver>
		<Priority>12</Priority>
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
				<Type>CTP</Type>
				<Priority>12</Priority>
				<BusinessArea>Bank</BusinessArea>
			</Header>
			<CTP xmlns:message="http://www.sdmx.org/resources/sdmxml/schemas/v2_1/message" xmlns:data="http://www.sdmx.org/resources/sdmxml/schemas/v2_1/data/structurespecific" xmlns:common="http://www.sdmx.org/resources/sdmxml/schemas/v2_1/common" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:BOL_RIAD_CTP="http://www.lb.lt/stattistic/anacredit/BOL_RIAD_CTP">
				<message:Header>
					<message:ID>${msgId}</message:ID>
					<message:Test>false</message:Test>
					<message:Prepared>${msgIdTimestamp}</message:Prepared>
					<message:Sender id="PRFTLT22XXX"/>
					<message:Receiver id="LIABLT2XMSD"/>
					<message:Structure structureID="BOL_RIAD_HDR_C" namespace="BOL_RIAD_HDR_C" dimensionAtObservation="AllDimensions">
						<common:Structure>
							<Ref agencyID="BOL" id="BOL_RIAD_HDR_C"/>
						</common:Structure>
					</message:Structure>
					<message:Structure structureID="BOL_RIAD_ENTTY_C" namespace="BOL_RIAD_ENTTY_C" dimensionAtObservation="AllDimensions">
						<common:Structure>
							<Ref agencyID="BOL" id="BOL_RIAD_ENTTY_C"/>
						</common:Structure>
					</message:Structure>
				</message:Header>
				<message:DataSet data:structureRef="BOL_RIAD_HDR_C" xsi:type="BOL_RIAD_CTP:BOL_RIAD_HDR_C" data:dataScope="DataStructure">
					<Obs ${data.rprtngAgnCdXML} DT_RPRTNG="${date}" SRVY_ID="BOL_RIAD_CTP" SBMSSN_TYP="FULL_DYNAMIC"/>
				</message:DataSet>
				<message:DataSet data:structureRef="BOL_RIAD_ENTTY_C" 
                    xsi:type="BOL_RIAD_CTP:BOL_RIAD_ENTTY_C"
                    data:dataScope="DataStructure" data:action="Replace">
					<Obs TYP_ENTTY="1"
					${data.nmEntityXML}
					${data.typNtlIdXML}
					${data.ntnlIdXML}
					${data.cntryXML}
					${data.strtXML}
					${data.ctyXML}
					${data.pstlCdXML}
					${data.lglFrmXML}
					${data.instttnlSctrXML}
					${data.ecnmcActvtyXML}
					${data.lglPrcdngSttsXML}
					${data.entityPrdbCdXML}/>
				</message:DataSet>
			</CTP>
		</Doc>
	</Docs>
</Msg>"""
    }

}
