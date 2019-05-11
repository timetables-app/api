package app.timetables.api.community.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import app.timetables.api.community.constraints.Password;

public class PasswordValidator implements ConstraintValidator<Password, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return StringUtils.hasText(value) && value.length() >= 8;
	}

}