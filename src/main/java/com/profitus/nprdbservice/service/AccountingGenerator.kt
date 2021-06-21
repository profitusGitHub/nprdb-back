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
class AccountingGenerator {
    @Autowired
    private lateinit var accountingRepository: AccountingRepository


    @Autowired
    private lateinit var msgIdRepository: MessageIdRepository
    private val msgIdPrefix: String = "PRFTLT";

    fun generate(reportId: String?): File? {
        val accounting = accountingRepository.findByReportId(reportId)

        val file = File.createTempFile("test", ".tmp")
        val writer = FileWriter(file)
        writer.write(populateValues(getNextMessageId(), accounting.get()))

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

    private fun populateValues(msgId: String, accounting: Accounting): String {
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
				<Type>CRDT3</Type>
				<Priority>11</Priority>
				<BusinessArea>Bank</BusinessArea>
			</Header>
			<CRDT3 xmlns:message="http://www.sdmx.org/resources/sdmxml/schemas/v2_1/message" xmlns:data="http://www.sdmx.org/resources/sdmxml/schemas/v2_1/data/structurespecific" xmlns:common="http://www.sdmx.org/resources/sdmxml/schemas/v2_1/common" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:BOL_ANCRDT_T2Q="http://www.lb.lt/stattistic/anacredit/BOL_ANCRDT_T2Q">
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
					<message:Structure structureID="BOL_ANCRDT_ACCNTNG_C" namespace="BOL_ANCRDT_ACCNTNG_C" dimensionAtObservation="AllDimensions">
						<common:Structure>
							<Ref agencyID="BOL" id="BOL_ANCRDT_ACCNTNG_C"/>
						</common:Structure>
					</message:Structure>
				</message:Header>
				<message:DataSet data:structureRef="BOL_ANCRDT_HDR_C" xsi:type="BOL_ANCRDT_T2Q:BOL_ANCRDT_HDR_C" data:dataScope="DataStructure">
					<Obs ${accounting.rprtngAgntCdXML} ${accounting.obsrvAgntCdXML} DT_RPRTNG="${date}" SRVY_ID="BOL_ANCRDT_T2Q" SBMSSN_TYP="FULL_DYNAMIC"/>
				</message:DataSet>
				<message:DataSet data:structureRef="BOL_ANCRDT_ACCNTNG_C" xsi:type="BOL_ANCRDT_T2Q:BOL_ANCRDT_ACCNTNG_C" data:dataScope="DataStructure" data:action="Replace">
					<Obs ${accounting.cntrctIdXML} 
                         ${accounting.instrmntIdXML} 
                         ${accounting.frbrncSttsXML}/>
				</message:DataSet>	
			</CRDT3>
		</Doc>
	</Docs>
</Msg>"""
    }

}
