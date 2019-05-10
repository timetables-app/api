package app.timetables.api.community.dto;

import app.timetables.api.community.constraints.Login;
import app.timetables.api.community.constraints.Password;
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
	@Login()
	private String loginOrEmail;
	
	/**
	 * Password
	 */
	@Password
	private String password;
}
