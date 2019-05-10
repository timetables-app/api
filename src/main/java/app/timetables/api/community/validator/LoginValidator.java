package app.timetables.api.community.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import app.timetables.api.community.constraints.Login;

public class LoginValidator implements ConstraintValidator<Login, String>{

	private static final Pattern LOGIN_PATTERN = Pattern.compile("^[a-zA-Z][a-zA-Z0-9@-]+$");
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return StringUtils.hasText(value) && LOGIN_PATTERN.matcher(value).matches();
	}

}