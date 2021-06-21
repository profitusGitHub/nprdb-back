package com.profitus.nprdbservice.controller;

import com.profitus.nprdbservice.model.CounterpartyReference;
import com.profitus.nprdbservice.model.MainNprdbReport;
import com.profitus.nprdbservice.repository.MainNprdbReportRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
@Ignore
public class NprdbReportControllerTest extends ControllerTest {
    @InjectMocks
    private NprdbReportController controller;
    @Mock
    private MainNprdbReportRepository repository;

    @Test
    public void createNewReportThenStatus201Created() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/v1/report-main")
                .content(gson.toJson(new MainNprdbReport()))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void getAllMainReportsThenSuccess() throws Exception {
        Mockito.when(repository.findAll()).thenReturn(Collections.EMPTY_LIST);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/report-main")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Override
    Object getController() {
        return controller;
    }
}