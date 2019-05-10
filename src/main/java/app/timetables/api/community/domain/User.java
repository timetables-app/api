package app.timetables.api.community.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import app.timetables.api.common.EntityBase;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER")
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class User extends EntityBase {
	@Column(name = "login")
	private String login;

	@Column(name = "password")
	private String password;

	@Column(name = "registration_date")
	private LocalDateTime registrationDate;

	@Embedded
	@AttributeOverrides(value = { @AttributeOverride(name = "value", column = @Column(name = "email")) })
	private Email email;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "comes_from")
	private String from;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	@Lob
    @Column(name = "profile_pic")
    private byte[] profilePic;

	@Column(name = "confirmed")
	@Getter
	private boolean confirmed;
	
	@Column(name = "password_reset")
	private boolean passwordReset;
	
	@Column(name = "password_change")
	private boolean passwordChange;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id", referencedColumnName = "id")
	private Company company;

	@Column(name = "is_owner")
	private boolean isOwner;

	private LocalDateTime modificationDate;

	private User(String login, String password, String email) {
		this.login = login;
		this.password = password;
		this.email = Email.of(email);
		this.confirmed = false;
	}

	public static User create(String login, String password, String email) {
		return new User(login, password, email);
	}

	public void assignCompany(Company company, boolean isOwner) {
		this.company = company;
		this.isOwner = isOwner;
		this.roles.add(Role.owner());
	}

	public void assignAdminPrivilages() {
		this.company = null;
		this.isOwner = false;
		this.roles.add(Role.admin());
	}

	// TODO
	public void update(String from) {
		this.from = from;
	}

	public void resetPassword() {
		this.passwordReset = true;
	}
	
	public void confirm() {
		this.confirmed = true;
	}
	
	public void setNewPassword(String password) {
		this.password = password;
		this.passwordChange = false;
	}
	
	@PrePersist
	protected void prePersist() {
		registrationDate = LocalDateTime.now();
	}

	@PreUpdate
	protected void preUpdate() {
		modificationDate = LocalDateTime.now();
	}
}
