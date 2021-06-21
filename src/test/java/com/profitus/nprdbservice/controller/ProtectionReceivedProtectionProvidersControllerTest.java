package com.profitus.nprdbservice.controller;

import com.profitus.nprdbservice.model.ProtectionReceived;
import com.profitus.nprdbservice.model.ProtectionReceivedProtectionProviders;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
@Ignore
public class ProtectionReceivedProtectionProvidersControllerTest extends ControllerTest{
    @InjectMocks
    private ProtectionReceivedProtectionProvidersController controller;

    @Test
    public void createCounterPartyData() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/v1/protection-received-protection-providers")
                .content(gson.toJson(new ProtectionReceivedProtectionProviders()))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void updateCounterpartyData() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .put("/v1/protection-received-protection-providers/someId")
                .content(gson.toJson(new ProtectionReceivedProtectionProviders()))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getCounterpartyData() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/protection-received-protection-providers/someId")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Override
    Object getController() {
        return controller;
    }
}