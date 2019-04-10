package app.timetables.api.community.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.timetables.api.common.Response;
import app.timetables.api.community.dto.UserRegistrationRequestDTO;
import app.timetables.api.community.service.UserRegistrationService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/users/register")
public class UserRegistrationController {

	@Autowired
	private UserRegistrationService service;
	
	@PostMapping
	public Response<Void> register(@Valid @RequestBody UserRegistrationRequestDTO dto) {
		service.register(dto);
		return Response.success();
	}
	
	@GetMapping("/available")
	public Response<Boolean> emailAvailable(@RequestParam(name = "email") String email, @RequestParam(name = "username") String username) {
		return Response.success(StringUtils.isEmpty(email) ? service.usernameAvailable(username) : service.emailAvailable(email));
	}
	
	//TODO later stages
	/*
	@GetMapping
	public void resetPassword() {
		
	}
	
	public void confirmUser() {
		
	}
	
	public void confirmPassword() {
		
	}
	
	public void updatePassword() {
		
	}*/
}
