package app.timetables.api.community.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationRequestDTO implements Serializable {

	private static final long serialVersionUID = 1311822341962973389L;

	@NotNull(message = "LOGIN_REQUIRED")
	@NotBlank(message = "LOGIN_REQUIRED")
	private String login;
	
	@NotNull(message = "PASSWORD_REQUIRED")
	@NotBlank(message = "PASSWORD_REQUIRED")
	@Length(min = 8, message = "PASSWORD_LENGTH")
	private String password;
	
	@NotNull(message = "EMAIL_REQUIRED")
	@NotBlank(message = "EMAIL_REQUIRED")
	private String email;
}
