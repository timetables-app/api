package app.timetables.api.community.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import app.timetables.api.common.EntityBase;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "AUTH_TOKEN")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthToken extends EntityBase {
	
	@Column(name = "TOKEN")
	@Getter
	private String value;
	
	public static AuthToken of(String value) {
		AuthToken token = new AuthToken();
		token.value = value;
		return token;
	}
}
