package app.timetables.api.community.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import app.timetables.api.common.EntityBase;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * User role.
 * @author kmrozowski
 *
 */
@Entity
@Table(name = "ROLE")
@Getter
@NoArgsConstructor(access=AccessLevel.PRIVATE)
public final class Role extends EntityBase {
	
	@Enumerated(EnumType.STRING)
	@Column(length = 60, name = "NAME")
	private RoleName name;
	
	private Role(RoleName name) {
		this.name = name;
	}
	
	public static Role normal() {
		return new Role(RoleName.ROLE_USER);
	}
	
	public static Role admin() {
		return new Role(RoleName.ROLE_ADMIN);
	}
	
	public static Role owner() {
		return new Role(RoleName.ROLE_OWNER);
	}
}
