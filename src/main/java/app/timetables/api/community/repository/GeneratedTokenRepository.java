package app.timetables.api.community.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import app.timetables.api.common.BusinessException;
import app.timetables.api.community.domain.GeneratedToken;

/**
 * Generated token repository
 * @author kmrozowski
 *
 */
public interface GeneratedTokenRepository extends CrudRepository<GeneratedToken, Long> {
	
	/**
	 * Finds token by it's value.
	 */
	Optional<GeneratedToken> findByToken(String token);
	
	Optional<GeneratedToken> findByUserLogin(String login);
	
	/**
	 * Gets token by it's value. If the token is not in the database or token is not valid, bussiness exception is raised.
	 */
	default GeneratedToken getByValue(String token) {
		GeneratedToken foundToken = findByToken(token).orElseThrow(() -> new BusinessException("NO_SUCH_TOKEN"));
		if(!foundToken.isValid()) {
			throw new BusinessException("INVALID_TOKEN");
		}
		return foundToken;
	}
}
