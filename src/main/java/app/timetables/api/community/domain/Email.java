package app.timetables.api.community.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access=AccessLevel.PRIVATE)
public class Email {
	@NotNull
	private String value;
	
	private Email(@NotNull String value) {
		this.value = value;
	}

	public static Email of(String email) {
		return new Email(email);
	}
}
