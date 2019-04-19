package app.timetables.api.search.community.controller;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import app.timetables.api.MainApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CompanySearchControllerTest {

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

}