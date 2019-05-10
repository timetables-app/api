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

import app.timetables.api.common.GenericResponseDto;
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
	public GenericResponseDto<Void> register(@Valid @RequestBody UserRegistrationRequestDTO dto) {
		service.register(dto);
		return GenericResponseDto.success();
	}
	
	/**
	 * Checks if email or login is available
	 * @param email
	 * @param username
	 * @return
	 */
	@GetMapping("/user/available")
	public GenericResponseDto<Boolean> emailAvailable(@RequestParam(name = "email") String email, @RequestParam(name = "username") String username) {
		return GenericResponseDto.success(StringUtils.isEmpty(email) ? service.usernameAvailable(username) : service.emailAvailable(email));
	}
	
	@GetMapping("/user/confirm")
	public GenericResponseDto<Void> confirmUser(@RequestParam(name = "token") String token) {
		service.confirmUser(token);
		return GenericResponseDto.success();
	}
	
	/**
	 * Resets user password.
	 * @return
	 */
	@GetMapping("/password/reset")
	public GenericResponseDto<Void> resetPassword() {
		service.resetPassword();
		return GenericResponseDto.success();
	}
	
	
	/**
	 * Confirms user password change
	 * @param token
	 */
	@GetMapping("/password/confirm")
	public GenericResponseDto<Void> confirmPassword(@RequestParam(name = "token") String token, @RequestParam(name = "password") String password) {
		service.confirmPassword(token, password);
		return GenericResponseDto.success();
	}
	
	@GetMapping("/password/update")
	public GenericResponseDto<Void> updatePassword(@RequestParam(name = "password") @Password String password) {
		service.updatePassword(password);
		return GenericResponseDto.success();
	}
}
