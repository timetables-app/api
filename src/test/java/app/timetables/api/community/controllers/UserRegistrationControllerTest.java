package app.timetables.api.community.controllers;

import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.timetables.api.MainApp;
import app.timetables.api.common.GenericResponseDto;
import app.timetables.api.community.domain.GeneratedToken;
import app.timetables.api.community.dto.UserLoginRequestDTO;
import app.timetables.api.community.dto.UserRegistrationRequestDTO;
import app.timetables.api.community.repository.GeneratedTokenRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRegistrationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private GeneratedTokenRepository tokenRepository;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	public void emailAvailableOK() throws Exception {
		 mockMvc.perform(get("/users/register/user/available?email=test3@test.pl"))
         .andExpect(status().isOk())
         .andExpect(jsonPath("$.success", is(true)))
         .andExpect(jsonPath("$.value", is(true)));
	}
	
	@Test
	public void emailAvailableNOTOK() throws Exception {
		 mockMvc.perform(get("/users/register/user/available?email=test@test.pl"))
         .andExpect(status().isOk())
         .andExpect(jsonPath("$.success", is(true)))
         .andExpect(jsonPath("$.value", is(false)));
	}
	
	@Test
	public void loginAvailableOK() throws Exception {
		mockMvc.perform(get("/users/register/user/available?login=testlogin0"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success", is(true)))
        .andExpect(jsonPath("$.value", is(true)));
	}
	
	@Test
	public void loginAvailableNOTOK() throws Exception {
		mockMvc.perform(get("/users/register/user/available?login=testlogin"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success", is(true)))
        .andExpect(jsonPath("$.value", is(false)));
	}
	
	@Test
	public void registerUser() throws Exception {
		UserRegistrationRequestDTO request = new UserRegistrationRequestDTO("testlogin1", "testpass1", "test1@test.pl");
		mockMvc.perform(post("/users/register")
		 .contentType(MediaType.APPLICATION_JSON)
         .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success", is(true)));
	
	}
	
	@Test
	public void confirmUser() throws Exception {
		//We simulate email token for testing purposes
		Optional<GeneratedToken> tokenValue = tokenRepository.findById(1L);
		if(!tokenValue.isPresent()) {
			fail();
		}
		String val = tokenValue.get().getToken();
		mockMvc.perform(get("/users/register/user/confirm?token=" + val))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success", is(true)));
	}
	
	@Test
	public void loginUser() throws Exception {
		loginUser("testlogin4", "Qwerty123")
		 .andExpect(status().isOk())
	     .andExpect(jsonPath("$.success", is(true)))
	     .andExpect(jsonPath("$.value", isA(String.class)));
	}
	
	@Test
	public void resetPassword() throws Exception {
		MvcResult result = loginUser("testloginreset", "Qwerty123")
		  .andExpect(status().isOk())
		 .andExpect(jsonPath("$.success", is(true)))
	     .andExpect(jsonPath("$.value", isA(String.class)))
	     .andReturn();
		
		GenericResponseDto<String> tokenResp = objectMapper.readValue(result.getResponse().getContentAsString(), GenericResponseDto.class);
		
		mockMvc.perform(get("/users/register/password/reset")
				.header("Authorization", "Bearer " + tokenResp.getValue()))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success", is(true)));
		
	}
	
	private ResultActions loginUser(String user, String pass) throws Exception {
		UserLoginRequestDTO request = new UserLoginRequestDTO(user, pass);
		return mockMvc.perform(post("/users/login")
				.contentType(MediaType.APPLICATION_JSON)
		         .content(objectMapper.writeValueAsString(request)));
	}
}
