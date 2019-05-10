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
import app.timetables.api.community.constraints.Password;
import app.timetables.api.community.dto.UserRegistrationRequestDTO;
import app.timetables.api.community.service.UserRegistrationService;
import lombok.AllArgsConstructor;

/**
 * Controller for user registration related stuff.
 * @author kmrozowski
 *
 */
@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/users/register")
public class UserRegistrationController {

	@Autowired
	private UserRegistrationService service;
	
	/**
	 * Register user endpoint.
	 * @param dto
	 * @return
	 */
	@PostMapping
	public GenericResponse<Void> register(@Valid @RequestBody UserRegistrationRequestDTO dto) {
		service.register(dto);
		return GenericResponse.success();
	}
	
	/**
	 * Checks if email or login is available
	 * @param email
	 * @param username
	 * @return
	 */
	@GetMapping("/user/available")
	public GenericResponse<Boolean> emailAvailable(@RequestParam(name = "email") String email, @RequestParam(name = "username") String username) {
		return GenericResponse.success(StringUtils.isEmpty(email) ? service.usernameAvailable(username) : service.emailAvailable(email));
	}
	
	@GetMapping("/user/confirm")
	public GenericResponse<Void> confirmUser(@RequestParam(name = "token") String token) {
		service.confirmUser(token);
		return GenericResponse.success();
	}
	
	/**
	 * Resets user password.
	 * @return
	 */
	@GetMapping("/password/reset")
	public GenericResponse<Void> resetPassword() {
		service.resetPassword();
		return GenericResponse.success();
	}
	
	
	/**
	 * Confirms user password change
	 * @param token
	 */
	@GetMapping("/password/confirm")
	public GenericResponse<Void> confirmPassword(@RequestParam(name = "token") String token, @RequestParam(name = "password") String password) {
		service.confirmPassword(token, password);
		return GenericResponse.success();
	}
	
	@GetMapping("/password/update")
	public GenericResponse<Void> updatePassword(@RequestParam(name = "password") @Password String password) {
		service.updatePassword(password);
		return GenericResponse.success();
	}
}
