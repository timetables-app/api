package app.timetables.api.community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import app.timetables.api.security.InMemoryTokenProvider;

@Service
public class UserService {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	InMemoryTokenProvider tokenProvider;

	/**
	 * Log in user.
	 * @param loginOrEmail
	 * @param password
	 * @return JWT token.
	 */
	public String login(String loginOrEmail, String password) {
		Authentication token = new UsernamePasswordAuthenticationToken(loginOrEmail, password);
		Authentication authentication = authenticationManager.authenticate(token);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		return tokenProvider.generateToken(authentication);
	}

}
