package com.profitus.nprdbservice.controller;

import com.google.gson.Gson;
import com.profitus.nprdbservice.model.Instrument;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
@Ignore
public class InstrumentControllerTest extends ControllerTest {
    @InjectMocks
    private InstrumentController controller;

    private MockMvc mockMvc;
    private Gson gson = new Gson();

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Override
    Object getController() {
        return controller;
    }

    @Test
    public void createInstrument() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/v1/instrument")
                .content(gson.toJson(new Instrument()))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void updateCounterpartyData() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .put("/v1/instrument/someId")
                .content(gson.toJson(new Instrument()))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getCounterpartyData() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/instrument/someId")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }

}