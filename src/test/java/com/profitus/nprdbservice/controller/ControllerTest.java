package com.profitus.nprdbservice.controller;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
abstract class ControllerTest {
    protected MockMvc mockMvc;
    protected Gson gson = new Gson();

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(getController()).build();
    }

    abstract Object getController();
}
