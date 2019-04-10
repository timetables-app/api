package app.timetables.api.community.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import app.timetables.api.community.domain.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{
	boolean existsByLogin(String login);
	
	Optional<User> findByLoginOrEmailValue(String username, String email);
}
