package app.timetables.api.community.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import app.timetables.api.common.BusinessException;
import app.timetables.api.community.domain.GeneratedToken;
import app.timetables.api.community.domain.User;
import app.timetables.api.community.dto.UserRegistrationRequestDTO;
import app.timetables.api.community.exception.MailerException;
import app.timetables.api.community.exception.UserDoesntExistsException;
import app.timetables.api.community.exception.UserExistsException;
import app.timetables.api.community.repository.GeneratedTokenRepository;
import app.timetables.api.community.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class UserRegistrationService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private GeneratedTokenRepository tokenRepository;
	
	@Autowired
	private MailSenderMock sender;
	
	public void register(UserRegistrationRequestDTO dto) {
		if(repository.existsByLogin(dto.getLogin())) {
			throw new UserExistsException();
		}
		
		User user = User.create(dto.getLogin(), passwordEncoder.encode(dto.getPassword()), dto.getEmail()); 
		user = repository.save(user);
		log.info("New user {}({}) with id {} registered", user.getLogin(), user.getEmail().getValue(), user.getId());
		GeneratedToken token = GeneratedToken.create(user);
		if(!sender.sendCreateToken(token)) {
			throw new MailerException();
		}
	}
	
	/**
	 * Checks if email address does not exists in the database.
	 * @param email
	 * @return
	 */
	public boolean emailAvailable(String email) {
		return !repository.existsByEmailValue(email);
	}
	
	/**
	 * Checks if username does not exists in the database.
	 * @param username
	 * @return
	 */
	public boolean usernameAvailable(String username) {
		return !repository.existsByLogin(username);
	}
	
	/**
	 * Resets user password and sends email with login
	 */
	public void resetPassword() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = repository.findByLogin(authentication.getName()).orElseThrow(() -> new UserDoesntExistsException());
		if(!user.isConfirmed()) {
			throw new BusinessException("USER_NOT_CONFIRMED");
		}
		GeneratedToken token = GeneratedToken.create(user);
		tokenRepository.save(token);
		if(!sender.sendResetPasswordToken(token)) {
			throw new MailerException();
		}
	}
	
	/**
	 * Confirms password change.
	 * @param token
	 */
	public void confirmUser(String token) {
		GeneratedToken foundToken = tokenRepository.getByValue(token);
		foundToken.getUser().confirm();
		tokenRepository.delete(foundToken);
	}
	
	/**
	 * Confirms password change.
	 * @param token
	 */
	public void confirmPassword(String token, String newPassword) {
		GeneratedToken foundToken = tokenRepository.getByValue(token);
		foundToken.getUser().setNewPassword(newPassword);
		tokenRepository.delete(foundToken);
	}

	public void updatePassword(String password) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = repository.findByLogin(authentication.getName()).orElseThrow(() -> new UserDoesntExistsException());
		if(password.equalsIgnoreCase(user.getPassword())) {
			throw new BusinessException("DIFFERENT_PASSWORD");
		}
		user.setNewPassword(password);
	}
	
}
