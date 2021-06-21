package com.profitus.nprdbservice.controller;

import com.profitus.nprdbservice.model.CounterpartyInstrument;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
@Ignore
public class CounterpartyInstrumentControllerTest extends ControllerTest {
    @InjectMocks
    private CounterpartyInstrumentController controller;

    @Test
    public void createInstrument() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/v1/counterparty-instrument")
                .content(gson.toJson(new CounterpartyInstrument()))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void updateCounterpartyData() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .put("/v1/counterparty-instrument/someId")
                .content(gson.toJson(new CounterpartyInstrument()))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getCounterpartyData() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/counterparty-instrument/someId")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Override
    Object getController() {
        return controller;
    }
}