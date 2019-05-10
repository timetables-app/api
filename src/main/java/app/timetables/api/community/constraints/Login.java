package app.timetables.api.community.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import app.timetables.api.community.validator.LoginValidator;

/**
 * Domain type representing user login.
 * @author kmrozowski
 *
 */
@Documented
@Constraint(validatedBy = LoginValidator.class)
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@NotNull(message = "LOGIN_REQUIRED")
@NotBlank(message = "LOGIN_REQUIRED")
public @interface Login {
	String message() default "INVALID_LOGIN_FORMAT";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
