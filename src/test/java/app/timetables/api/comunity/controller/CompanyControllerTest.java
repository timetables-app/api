package app.timetables.api.comunity.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerTest {

    public static final String APPROVE_URL = "/approve/company/1";

    public static final String BLOCK_URL = "/block/company/1";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testApproveController() throws Exception {
        mockMvc.perform(post(APPROVE_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.approved", is(true)));
    }

    @Test
    public void testBlockController() throws Exception {
        mockMvc.perform(post(BLOCK_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.approved", is(false)));
    }

}
