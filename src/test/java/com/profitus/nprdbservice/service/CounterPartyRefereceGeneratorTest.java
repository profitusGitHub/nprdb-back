package com.profitus.nprdbservice.service;

import com.profitus.nprdbservice.model.CounterpartyReference;
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
public class CounterPartyRefereceGeneratorTest {
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
        Mockito.when(repository.findByReportId(testReportId)).thenReturn(Optional.of(counterpartyReferenceFixture()));

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

    private String expectedXml = "<Msg ID=\"Edoc\" Type=\"CRDCTP\" Version=\"2017-1-0\">\n" +
            "\t<Header>\n" +
            "\t\t<Sender>PRFTLT2</Sender>\n" +
            "\t\t<Receiver>LIABLT2XMSD</Receiver>\n" +
            "\t\t<Priority>12</Priority>\n" +
            "\t\t<MsgId>20060209512233</MsgId>\n" +
            "\t\t<Date>2020-06-02T09:12:03</Date>\n" +
            "\t\t<System>PRDB</System>\n" +
            "\t</Header>\n" +
            "\t<Docs>\n" +
            "\t\t<Doc>\n" +
            "\t\t\t<Header>\n" +
            "\t\t\t\t<DocId>20060209512233</DocId>\n" +
            "\t\t\t\t<Dates>\n" +
            "\t\t\t\t\t<Type>FormDoc</Type>\n" +
            "\t\t\t\t\t<Date>2020-06-02T09:12:03</Date>\n" +
            "\t\t\t\t</Dates>\n" +
            "\t\t\t\t<Type>CTP</Type>\n" +
            "\t\t\t\t<Priority>12</Priority>\n" +
            "\t\t\t\t<BusinessArea>Bank</BusinessArea>\n" +
            "\t\t\t</Header>\n" +
            "\t\t\t<CTP xmlns:message=\"http://www.sdmx.org/resources/sdmxml/schemas/v2_1/message\" xmlns:data=\"http://www.sdmx.org/resources/sdmxml/schemas/v2_1/data/structurespecific\" xmlns:common=\"http://www.sdmx.org/resources/sdmxml/schemas/v2_1/common\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:BOL_RIAD_CTP=\"http://www.lb.lt/stattistic/anacredit/BOL_RIAD_CTP\">\n" +
            "\t\t\t\t<message:Header>\n" +
            "\t\t\t\t\t<message:ID>PRFTLT2</message:ID>\n" +
            "\t\t\t\t\t<message:Test>false</message:Test>\n" +
            "\t\t\t\t\t<message:Prepared>2020-06-02T09:12:03</message:Prepared>\n" +
            "\t\t\t\t\t<message:Sender id=\"PRFTLT22XXX\"/>\n" +
            "\t\t\t\t\t<message:Receiver id=\"LIABLT2XMSD\"/>\n" +
            "\t\t\t\t\t<message:Structure structureID=\"BOL_RIAD_HDR_C\" namespace=\"BOL_RIAD_HDR_C\" dimensionAtObservation=\"AllDimensions\">\n" +
            "\t\t\t\t\t\t<common:Structure>\n" +
            "\t\t\t\t\t\t\t<Ref agencyID=\"BOL\" id=\"BOL_RIAD_HDR_C\"/>\n" +
            "\t\t\t\t\t\t</common:Structure>\n" +
            "\t\t\t\t\t</message:Structure>\n" +
            "\t\t\t\t\t<message:Structure structureID=\"BOL_RIAD_ENTTY_C\" namespace=\"BOL_RIAD_ENTTY_C\" dimensionAtObservation=\"AllDimensions\">\n" +
            "\t\t\t\t\t\t<common:Structure>\n" +
            "\t\t\t\t\t\t\t<Ref agencyID=\"BOL\" id=\"BOL_RIAD_ENTTY_C\"/>\n" +
            "\t\t\t\t\t\t</common:Structure>\n" +
            "\t\t\t\t\t</message:Structure>\n" +
            "\t\t\t\t</message:Header>\n" +
            "\t\t\t\t<message:DataSet data:structureRef=\"BOL_RIAD_HDR_C\" xsi:type=\"BOL_RIAD_CTP:BOL_RIAD_HDR_C\" data:dataScope=\"DataStructure\">\n" +
            "\t\t\t\t\t<Obs RPRTNG_AGNT_CD=\"304570552\" DT_RPRTNG=\"2020-06-02\" SRVY_ID=\"BOL_RIAD_CTP\" SBMSSN_TYP=\"FULL_DYNAMIC\"/>\n" +
            "\t\t\t\t</message:DataSet>\n" +
            "\t\t\t\t<message:DataSet data:structureRef=\"BOL_RIAD_ENTTY_C\" xsi:type=\"BOL_RIAD_CTP:BOL_RIAD_ENTTY_C\" data:dataScope=\"DataStructure\" data:action=\"Replace\">\n" +
            "\t\t\t\t\t<Obs TYP_ENTTY=\"1\"\n" +
            "\t\t\t\t\tNM_ENTTY=\"UAB Vasario 16\"\n" +
            "\t\t\t\t\tTYP_NTNL_ID=\"LT_JAR_CD\"\n" +
            "\t\t\t\t\tNTNL_ID=\"305231423\"\n" +
            "\t\t\t\t\tCNTRY=\"LT\"\n" +
            "\t\t\t\t\tSTRT=\"Dzūkų g.\"\n" +
            "\t\t\t\t\tCTY=\"Vilnius\"\n" +
            "\t\t\t\t\tPSTL_CD=\"02115\"\n" +
            "\t\t\t\t\tLGL_FRM=\"LT102\"\n" +
            "\t\t\t\t\tINSTTTNL_SCTR=\"S11\"\n" +
            "\t\t\t\t\tECNMC_ACTVTY=\"68\"\n" +
            "\t\t\t\t\tLGL_PRCDNG_STTS=\"1\"\n" +
            "\t\t\t\t\tENTTY_PRDB_CD=\"305231423\"/>\n" +
            "\t\t\t\t</message:DataSet>\n" +
            "\t\t\t</CTP>\n" +
            "\t\t</Doc>\n" +
            "\t</Docs>\n" +
            "</Msg>\n";


    private CounterpartyReference counterpartyReferenceFixture(){
        CounterpartyReference fixture = new CounterpartyReference();

        fixture.setRprtngAgnCd("304570552");
        fixture.setEntityPrdbCd("305231423");
        fixture.setLei("305231423");//*
        fixture.setTypNtlId("LT_JAR_CD");
        fixture.setDscrptnOntnlId("someDescription");//*
        fixture.setNtnlId("305231423");
        fixture.setNmEntity("UAB Vasario 16");
        fixture.setStrt("Dzūkų g.");
        fixture.setCty("Vilnius");
        fixture.setPstlCd("02115");
        fixture.setCntry("LT");
        fixture.setLglFrm("LT102");
        fixture.setInstttnlSctr("S11");
        fixture.setEcnmcActvty("68");
        fixture.setLglPrcdngStts("1");
        return fixture;
    }

}
