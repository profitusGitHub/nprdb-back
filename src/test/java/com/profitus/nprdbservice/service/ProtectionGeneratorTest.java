package com.profitus.nprdbservice.service;

import com.profitus.nprdbservice.model.MessageId;
import com.profitus.nprdbservice.repository.CounterpartyReferenceRepository;
import com.profitus.nprdbservice.repository.MessageIdRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@Ignore
public class ProtectionGeneratorTest {
    @InjectMocks
    private CounterPartyRefereceGenerator serviceKotlin;
    @Mock
    private CounterpartyReferenceRepository repository;
    @Mock
    private MessageIdRepository msgIdRepository;
    private String testReportId = "someId";
    @Captor
    private ArgumentCaptor<MessageId> msgIdCaptor;

    @Before
    public void setUp() {
        //Mockito.when(repository.findByReportId(testReportId)).thenReturn(Optional.of(counterpartyReferenceFixture()));

        Mockito.when(msgIdRepository.findFirstBy()).thenReturn(Optional.of(new MessageId(2L)));
    }


    @Test
    public void generateCounterpartyReferenceFile() {
        File result = serviceKotlin.generate(testReportId);
        String resultA = fileStringContent(result.getPath());

        verify(repository, times(1)).findByReportId(testReportId);

        Assert.assertEquals(resultA, expectedXml);
    }

    private static String fileStringContent(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }


    String expectedXml  = "<Msg ID=\"Edoc\" Type=\"CRDQUE\" Version=\"2017-1-0\">\n" +
            "\t<Header>\n" +
            "\t\t<Sender>PRFTLT22XXX</Sender>\n" +
            "\t\t<Receiver>LIABLT2XMSD</Receiver>\n" +
            "\t\t<Priority>11</Priority>\n" +
            "\t\t<MsgId>20052810252233</MsgId>\n" +
            "\t\t<Date>2020-05-28T10:25:03</Date>\n" +
            "\t\t<System>PRDB</System>\n" +
            "\t</Header>\n" +
            "\t<Docs>\n" +
            "\t\t<Doc>\n" +
            "\t\t\t<Header>\n" +
            "\t\t\t\t<DocId>20052810252233</DocId>\n" +
            "\t\t\t\t<Dates>\n" +
            "\t\t\t\t\t<Type>FormDoc</Type>\n" +
            "\t\t\t\t\t<Date>2020-05-28T10:25:03</Date>\n" +
            "\t\t\t\t</Dates>\n" +
            "\t\t\t\t<Type>CRDT1</Type>\n" +
            "\t\t\t\t<Priority>11</Priority>\n" +
            "\t\t\t\t<BusinessArea>Bank</BusinessArea>\n" +
            "\t\t\t</Header>\n" +
            "\t\t\t<CRDT1 xmlns:message=\"http://www.sdmx.org/resources/sdmxml/schemas/v2_1/message\" \n" +
            "\t\t\txmlns:data=\"http://www.sdmx.org/resources/sdmxml/schemas/v2_1/data/structurespecific\" \n" +
            "\t\t\txmlns:common=\"http://www.sdmx.org/resources/sdmxml/schemas/v2_1/common\" \n" +
            "\t\t\txmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" \n" +
            "\t\t\txmlns:BOL_ANCRDT_T1M=\"http://www.lb.lt/stattistic/anacredit/BOL_ANCRDT_T1M\">\n" +
            "\t\t\t\t<message:Header>\n" +
            "\t\t\t\t\t<message:ID>prft00006</message:ID>\n" +
            "\t\t\t\t\t<message:Test>false</message:Test>\n" +
            "\t\t\t\t\t<message:Prepared>2020-05-28T10:25:03</message:Prepared>\n" +
            "\t\t\t\t\t<message:Sender id=\"PRFTLT22XXX\"/>\n" +
            "\t\t\t\t\t<message:Receiver id=\"LIABLT2XMSD\"/>\t\n" +
            "\t\t\t\t\t<message:Structure structureID=\"BOL_ANCRDT_HDR_C\" namespace=\"BOL_ANCRDT_HDR_C\" dimensionAtObservation=\"AllDimensions\">\n" +
            "\t\t\t\t\t\t<common:Structure>\n" +
            "\t\t\t\t\t\t\t<Ref agencyID=\"BOL\" id=\"BOL_ANCRDT_HDR_C\"/>\n" +
            "\t\t\t\t\t\t</common:Structure>\n" +
            "\t\t\t\t\t</message:Structure>\n" +
            "\t\t\t\t\t<message:Structure structureID=\"BOL_ANCRDT_INSTRMNT_C\" namespace=\"BOL_ANCRDT_INSTRMNT_C\" dimensionAtObservation=\"AllDimensions\">\n" +
            "\t\t\t\t\t\t<common:Structure>\n" +
            "\t\t\t\t\t\t\t<Ref agencyID=\"BOL\" id=\"BOL_ANCRDT_INSTRMNT_C\"/>\n" +
            "\t\t\t\t\t\t</common:Structure>\n" +
            "\t\t\t\t\t</message:Structure>\n" +
            "\t\t\t\t\t<message:Structure structureID=\"BOL_ANCRDT_JNT_LBLTS_C\" namespace=\"BOL_ANCRDT_JNT_LBLTS_C\" dimensionAtObservation=\"AllDimensions\">\n" +
            "\t\t\t\t\t\t<common:Structure>\n" +
            "\t\t\t\t\t\t\t<Ref agencyID=\"BOL\" id=\"BOL_ANCRDT_JNT_LBLTS_C\"/>\n" +
            "\t\t\t\t\t\t</common:Structure>\n" +
            "\t\t\t\t\t</message:Structure>\n" +
            "\t\t\t\t\t<message:Structure structureID=\"BOL_ANCRDT_FNNCL_C\" namespace=\"BOL_ANCRDT_FNNCL_C\" dimensionAtObservation=\"AllDimensions\">\n" +
            "\t\t\t\t\t\t<common:Structure>\n" +
            "\t\t\t\t\t\t\t<Ref agencyID=\"BOL\" id=\"BOL_ANCRDT_FNNCL_C\"/>\n" +
            "\t\t\t\t\t\t</common:Structure>\n" +
            "\t\t\t\t\t</message:Structure>\n" +
            "\t\t\t\t\t<message:Structure structureID=\"BOL_ANCRDT_ENTTY_INSTRMNT_C\" namespace=\"BOL_ANCRDT_ENTTY_INSTRMNT_C\" dimensionAtObservation=\"AllDimensions\">\n" +
            "\t\t\t\t\t\t<common:Structure>\n" +
            "\t\t\t\t\t\t\t<Ref agencyID=\"BOL\" id=\"BOL_ANCRDT_ENTTY_INSTRMNT_C\"/>\n" +
            "\t\t\t\t\t\t</common:Structure>\n" +
            "\t\t\t\t\t</message:Structure>\n" +
            "\t\t\t\t</message:Header>\n" +
            "\t\t\t\t<message:DataSet data:structureRef=\"BOL_ANCRDT_HDR_C\" xsi:type=\"BOL_ANCRDT_T1M:BOL_ANCRDT_HDR_C\" data:dataScope=\"DataStructure\">\n" +
            "\t\t\t\t\t<Obs RPRTNG_AGNT_CD=\"304570552\"\n" +
            "\t\t\t\t\tOBSRVD_AGNT_CD=\"304570552\" \t\t\t\t\t\n" +
            "\t\t\t\t\tSRVY_ID=\"BOL_ANCRDT_T1M\"\n" +
            "\t\t\t\t\tDT_RPRTNG=\"2020-05-27\" \n" +
            "\t\t\t\t\tSBMSSN_TYP=\"FULL_DYNAMIC\"/>\n" +
            "\t\t\t\t</message:DataSet>\n" +
            "\t\t\t\t<message:DataSet data:structureRef=\"BOL_ANCRDT_INSTRMNT_C\" xsi:type=\"BOL_ANCRDT_T1M:BOL_ANCRDT_INSTRMNT_C\" data:dataScope=\"DataStructure\" data:action=\"Replace\">\n" +
            "\t\t\t\t\t<Obs CNTRCT_ID=\"16-2003-1\"\n" +
            "\t\t\t\t\tINSTRMNT_ID=\"#183\"\n" +
            "\t\t\t\t\tTYP_INSTRMNT=\"1004_A\"\n" +
            "\t\t\t\t\tTYP_AMRTSTN=\"4\"\n" +
            "\t\t\t\t\tISO4217=\"EUR\"\n" +
            "\t\t\t\t\tDT_INCPTN=\"2020-03-17\"\n" +
            "\t\t\t\t\tFRQNCY_INTRST_RT_RST=\"0\"\n" +
            "\t\t\t\t\tTYP_INTRST_RT=\"1\"\n" +
            "\t\t\t\t\tDT_LGL_FNL_MTRTY=\"2021-03-16\"\n" +
            "\t\t\t\t\tCMMTMNT_INCPTN=\"31200\"\n" +
            "\t\t\t\t\tPYMNT_FRQNCY=\"18\"\n" +
            "\t\t\t\t\tPRJCT_FNNC_LN=\"2\"\n" +
            "\t\t\t\t\tPRPS=\"8_C\"\n" +
            "\t\t\t\t\tDT_STTLMNT=\"2021-03-16\"\n" +
            "\t\t\t\t\tRPYMNT_RGHTS=\"2\"\n" +
            "\t\t\t\t\tRFRNC_RT_INDX=\"NA\"\n" +
            "\t\t\t\t\tRFRNC_RT_MTRT=\"NA\"/>\n" +
            "\t\t\t\t</message:DataSet>\n" +
            "\t\t\t\t<message:DataSet data:structureRef=\"BOL_ANCRDT_FNNCL_C\" xsi:type=\"BOL_ANCRDT_T1M:BOL_ANCRDT_FNNCL_C\" data:dataScope=\"DataStructure\" data:action=\"Replace\">\n" +
            "\t\t\t\t\t<Obs CNTRCT_ID=\"16-2003-1\" INSTRMNT_ID=\"#183\" APPLD_RT=\"8\"/>\n" +
            "\t\t\t\t</message:DataSet>\n" +
            "\t\t\t\t<message:DataSet data:structureRef=\"BOL_ANCRDT_JNT_LBLTS_C\" xsi:type=\"BOL_ANCRDT_T1M:BOL_ANCRDT_JNT_LBLTS_C\" \n" +
            "\t\t\t\t\tdata:dataScope=\"DataStructure\" data:action=\"Replace\">\n" +
            "\t\t\t\t\t<Obs ENTTY_PRDB_CD=\"300588439\" \n" +
            "\t\t\t\t\t\t CNTRCT_ID=\"16-2003-1\"\n" +
            "\t\t\t\t\t\t INSTRMNT_ID=\"#183\"/>\n" +
            "\t\t\t\t</message:DataSet>\n" +
            "\t\t\t\t<message:DataSet data:structureRef=\"BOL_ANCRDT_ENTTY_INSTRMNT_C\" xsi:type=\"BOL_ANCRDT_T1M:BOL_ANCRDT_ENTTY_INSTRMNT_C\" data:dataScope=\"DataStructure\" data:action=\"Replace\">\n" +
            "\t\t\t\t\t<Obs ENTTY_PRDB_CD=\"300588439\" \n" +
            "\t\t\t\t\t\t CNTRCT_ID=\"16-2003-1\" \n" +
            "\t\t\t\t\t\t INSTRMNT_ID=\"#183\" \n" +
            "\t\t\t\t\t\t ENTTY_RL=\"2\"/>\n" +
            "\t\t\t\t</message:DataSet>\t\t\n" +
            "\t\t\t</CRDT1>\n" +
            "\t\t</Doc>\n" +
            "\t</Docs>\n" +
            "</Msg>";
}
