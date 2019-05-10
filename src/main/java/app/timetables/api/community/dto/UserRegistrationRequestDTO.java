package app.timetables.api.community.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import app.timetables.api.community.constraints.Login;
import app.timetables.api.community.constraints.Password;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * User registration request dto.
 * @author kmrozowski
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationRequestDTO implements Serializable {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 1311822341962973389L;

	/**
	 * Username. Required.
	 */
	@Login
	private String login;
	
	/**
	 * Password. At least 8 character. TODO custom validator.
	 */
	@Password
	private String password;
	
	/**
	 * Email. TODO custom validator
	 */
	@NotNull(message = "EMAIL_REQUIRED")
	@NotBlank(message = "EMAIL_REQUIRED")
	@Email
	private String email;
}
