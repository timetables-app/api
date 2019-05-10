package app.timetables.api.community.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import app.timetables.api.community.domain.AuthToken;

/**
 * Authenication token repository
 * @author kmrozowski
 *
 */
public interface AuthTokenRepository extends CrudRepository<AuthToken, Long>{
	boolean existsByValue(String value);
	Optional<AuthToken> findByValue(String value);
}
