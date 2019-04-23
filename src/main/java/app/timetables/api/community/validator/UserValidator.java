package app.timetables.api.community.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import app.timetables.api.community.domain.User;

public class UserValidator implements Validator {
	private final String NOT_BLANK_MSG = "Pole nie może być puste.";
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", NOT_BLANK_MSG);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", NOT_BLANK_MSG);
	}

}
