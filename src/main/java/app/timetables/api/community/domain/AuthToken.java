package app.timetables.api.community.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import app.timetables.api.common.EntityBase;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthToken extends EntityBase {
	
	@Column(name = "token")
	@Getter
	private String value;
	
	public static AuthToken of(String value) {
		AuthToken token = new AuthToken();
		token.value = value;
		return token;
	}
}
