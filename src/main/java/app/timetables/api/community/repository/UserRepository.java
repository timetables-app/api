package app.timetables.api.community.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import app.timetables.api.community.domain.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	/**
	 * Checks if user with specified login already exists in the database.
	 * @param login
	 * @return
	 */
	boolean existsByLogin(String login);
	
	/**
	 * Checks if user with specified email already exists in the database.
	 * @param login
	 * @return
	 */
	boolean existsByEmailValue(String email);
	
	/**
	 * Finds user based on login or email
	 * @param username
	 * @param email
	 * @return
	 */
	Optional<User> findByLoginOrEmailValue(String username, String email);
}
