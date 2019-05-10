package app.timetables.api.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import app.timetables.api.community.domain.User;
import lombok.Getter;

@Getter
public class TimetablesUserDetails implements UserDetails {

	private static final long serialVersionUID = -7636536938234537858L;

	@JsonIgnore
	private String password;

	private String username;

	private boolean enabled = true;

	private boolean accountNonLocked = true;

	private boolean accountNonExpired = true;

	private boolean credentialsNonExpired = true;

	private Collection<? extends GrantedAuthority> authorities;

	private Long id;

	public static TimetablesUserDetails create(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
		return new TimetablesUserDetails(user.getId(), user.getLogin(), user.getPassword(), authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	private TimetablesUserDetails(Long id, String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

}
