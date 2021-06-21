package com.profitus.nprdbservice.controller;

import com.profitus.nprdbservice.model.JointLiabilities;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
@Ignore
public class JointLiabilitiesControllerTest extends ControllerTest {
    @InjectMocks
    private JointLiabilitiesController controller;

    @Override
    Object getController() {
        return controller;
    }

    @Test
    public void createCounterPartyData() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/v1/joint-liabilities")
                .content(gson.toJson(new JointLiabilities()))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void updateCounterpartyData() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .put("/v1/joint-liabilities/someId")
                .content(gson.toJson(new JointLiabilities()))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getCounterpartyData() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/joint-liabilities/someId")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }


}