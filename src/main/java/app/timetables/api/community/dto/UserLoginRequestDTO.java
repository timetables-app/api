package app.timetables.api.community.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * User login request dto.
 * @author kmrozowski
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequestDTO {
	/**
	 * Username or email.
	 */
	private String loginOrEmail; //TODO walidacja spacji itd.
	
	/**
	 * Password
	 */
	private String password;
}
