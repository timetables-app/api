package app.timetables.api.community.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import app.timetables.api.community.domain.User;
import app.timetables.api.community.repository.UserRepository;
import app.timetables.api.security.TimetablesUserDetails;

@Service
@Transactional
public class TimetablesUserDetailService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByLoginOrEmailValue(username, username).orElseThrow(() -> new UsernameNotFoundException("NO_USER_FOUND"));
		return TimetablesUserDetails.create(user);
	}
	
	public UserDetails loadUserById(Long Id) throws UsernameNotFoundException {
		User user = userRepository.findById(Id).orElseThrow(() -> new UsernameNotFoundException("NO_USER_FOUND"));
		return TimetablesUserDetails.create(user);
	}
}
