package app.timetables.api.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import app.timetables.api.community.domain.User;
import lombok.Getter;

@Getter
public class TimetablesUserDetails implements UserDetails {

	private static final long serialVersionUID = -7636536938234537858L;
	
	private String password;
	private String username;
	private boolean enabled = true;
	private boolean accountNonLocked = true;
	private boolean accountNonExpired = true;
	private boolean credentialsNonExpired = true;
	private Long id;
	
	
	public static TimetablesUserDetails create(User user) {
		return new TimetablesUserDetails(user.getId(), user.getLogin(), user.getPassword());
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	private TimetablesUserDetails(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

}
