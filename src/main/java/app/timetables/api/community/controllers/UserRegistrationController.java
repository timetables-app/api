package app.timetables.api.community.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.timetables.api.common.GenericResponse;
import app.timetables.api.community.dto.UserRegistrationRequestDTO;
import app.timetables.api.community.service.UserRegistrationService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/users/register")
public class UserRegistrationController {

	@Autowired
	private UserRegistrationService service;
	
	@PostMapping
	public GenericResponse<Void> register(@Valid @RequestBody UserRegistrationRequestDTO dto) {
		service.register(dto);
		return GenericResponse.success();
	}
	
	@GetMapping("/available")
	public GenericResponse<Boolean> emailAvailable(@RequestParam(name = "email") String email, @RequestParam(name = "username") String username) {
		return GenericResponse.success(StringUtils.isEmpty(email) ? service.usernameAvailable(username) : service.emailAvailable(email));
	}
	
	@GetMapping("/password/reset")
	public GenericResponse<Void> resetPassword() {
		service.resetPassword();
		return GenericResponse.success();
	}
	
	public void confirmUser() {
		
	}
	
	@GetMapping("/password/confirm")
	public void confirmPassword(@RequestParam(name = "token") String token) {
		
	}
	
	public void updatePassword() {
		
	}
}
