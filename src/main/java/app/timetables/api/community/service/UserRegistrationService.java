package app.timetables.api.community.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import app.timetables.api.community.domain.PasswordResetToken;
import app.timetables.api.community.domain.User;
import app.timetables.api.community.dto.UserRegistrationRequestDTO;
import app.timetables.api.community.exception.MailerException;
import app.timetables.api.community.exception.UserDoesntExistsException;
import app.timetables.api.community.exception.UserExistsException;
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
	private MailSender sender;
	
	public void register(UserRegistrationRequestDTO dto) {
		if(repository.existsByLogin(dto.getLogin())) {
			throw new UserExistsException();
		}
		
		User user = User.create(dto.getLogin(), passwordEncoder.encode(dto.getPassword()), dto.getEmail()); 
		user = repository.save(user);
		log.info("New user {}({}) with id {} registered", user.getLogin(), user.getEmail().getValue(), user.getId());
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
		//TODO invalidate user
		PasswordResetToken token = PasswordResetToken.create(user);
		if(!sender.sendResetPasswordToken(token)) {
			throw new MailerException();
		}
	}
	
}
