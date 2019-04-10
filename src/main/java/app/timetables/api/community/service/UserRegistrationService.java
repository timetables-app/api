package app.timetables.api.community.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import app.timetables.api.community.domain.User;
import app.timetables.api.community.dto.UserRegistrationRequestDTO;
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
	
	public void register(UserRegistrationRequestDTO dto) {
		if(repository.existsByLogin(dto.getLogin())) {
			throw new UserExistsException();
		}
		
		User user = User.create(dto.getLogin(), passwordEncoder.encode(dto.getPassword()), dto.getEmail()); 
		user = repository.save(user);
		log.info("New user {}({}) with id {} registered", user.getLogin(), user.getEmail().getValue(), user.getId());
	}
}
