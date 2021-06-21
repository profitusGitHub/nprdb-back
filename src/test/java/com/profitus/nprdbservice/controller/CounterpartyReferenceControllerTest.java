package com.profitus.nprdbservice.controller;

import com.profitus.nprdbservice.model.CounterpartyReference;
import com.profitus.nprdbservice.repository.CounterpartyReferenceRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.mockito.Matchers.any;
@Ignore
public class CounterpartyReferenceControllerTest extends ControllerTest {
    @InjectMocks
    private CounterpartyReferenceController controller;
    @Mock
    private CounterpartyReferenceRepository repository;

    @Override
    Object getController() {
        return controller;
    }

    @Test
     public void createCounterPartyData() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/v1/counterparty-reference")
                .content(gson.toJson(new CounterpartyReference()))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void updateCounterpartyData() throws Exception {
        Mockito.when(repository.findByReportId(any())).thenReturn(Optional.of(new CounterpartyReference(1L)));
        mockMvc.perform(MockMvcRequestBuilders
                .put("/v1/counterparty-reference/someId")
                .content(gson.toJson(new CounterpartyReference()))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getCounterpartyData() throws Exception {
        Mockito.when(repository.findByReportId(any())).thenReturn(Optional.of(new CounterpartyReference(1L)));
        mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/counterparty-reference/someId")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }
}