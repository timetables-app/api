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

import org.hibernate.validator.constraints.Length;

import app.timetables.api.community.validator.PasswordValidator;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@NotNull(message = "PASSWORD_REQUIRED")
@NotBlank(message = "PASSWORD_REQUIRED")
@Length(min = 8, message = "PASSWORD_LENGTH")
public @interface Password {
	String message() default "INVALID_PASSWORD_FORMAT";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
