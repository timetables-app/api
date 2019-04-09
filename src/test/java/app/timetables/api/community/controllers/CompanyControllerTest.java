package app.timetables.api.community.controllers;

import app.timetables.api.MainApp;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CompanyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCompanyById200Status() throws Exception {
        mockMvc.perform(get("/companies/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Pierwsza firma")));
    }

    @Test
    public void getCompanyById404Status() throws Exception {
        mockMvc.perform(get("/companies/999")).andExpect(status().isNotFound());
    }

    @Test
    public void getCompanies() throws Exception {
        mockMvc.perform(get("/companies/?size=2&page=1&sort=id&direction=desc"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.length()", is(2)))
                .andExpect(jsonPath("$.pageable.pageNumber", is(1)));
    }

    @Test
    public void approveCompany() throws Exception {
        mockMvc.perform(post("/companies/approve/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.approved", is(true)));
    }

    @Test
    public void blockCompany() throws Exception {
        mockMvc.perform(post("/companies/block/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.approved", is(false)));
    }

    @Test
    public void approveAndBlockCompany() throws Exception {
        mockMvc.perform(post("/companies/approve/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.approved", is(true)));

        mockMvc.perform(post("/companies/block/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.approved", is(false)));
    }
}