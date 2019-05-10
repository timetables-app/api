package app.timetables.api.community.service;

import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import app.timetables.api.common.BusinessException;
import app.timetables.api.community.domain.AuthToken;
import app.timetables.api.community.repository.AuthTokenRepository;
import app.timetables.api.security.InMemoryTokenProvider;

/**
 * User lifecycle service
 * @author kmrozowski
 *
 */
@Service
public class UserService {
	private final static String AUTH_PREFIX = "Bearer ";
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	InMemoryTokenProvider tokenProvider;

	@Autowired
	AuthTokenRepository tokenRepository;
	
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
		String tokenValue = tokenProvider.generateToken(authentication);
		tokenRepository.save(AuthToken.of(tokenValue));
		return tokenValue;
	}

	/**
	 * Log user out
	 */
	public void logout(String tokenValue) {
		String parsedValue = tokenValue;
		if(StringUtils.isNullOrEmpty(parsedValue)) {
			throw new BusinessException("NO_TOKEN_PRESENT");
		}
		if(parsedValue.startsWith(AUTH_PREFIX)) {
			parsedValue = parsedValue.substring(AUTH_PREFIX.length());
		}
		AuthToken token = tokenRepository.findByValue(parsedValue).orElseThrow(() -> new BusinessException("TOKEN_DOES_NOT_EXISTS"));
		tokenRepository.delete(token);
	}
}
