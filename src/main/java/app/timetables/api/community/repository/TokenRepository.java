package app.timetables.api.community.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import app.timetables.api.common.BusinessException;
import app.timetables.api.community.domain.GeneratedToken;

public interface TokenRepository extends CrudRepository<GeneratedToken, Long> {
	
	Optional<GeneratedToken> findByToken(String token);
	
	default GeneratedToken getByValue(String token) {
		GeneratedToken foundToken = findByToken(token).orElseThrow(() -> new BusinessException("NO_SUCH_TOKEN"));
		if(!foundToken.isValid()) {
			throw new BusinessException("INVALID_TOKEN");
		}
		return foundToken;
	}
}
