package app.timetables.api.community.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.timetables.api.common.Response;
import app.timetables.api.community.dto.UserLoginRequestDTO;
import app.timetables.api.community.service.UserService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping("/login")
	public Response<String> login(@Valid @RequestBody UserLoginRequestDTO dto) {
		return Response.success(service.login(dto.getLoginOrEmail(), dto.getPassword()));
	}
}
