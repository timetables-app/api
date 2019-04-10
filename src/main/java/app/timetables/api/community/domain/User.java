package app.timetables.api.community.domain;

import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import app.timetables.api.common.EntityBase;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="USER")
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class User extends EntityBase {
	@Column(name = "login")
	private String login;
	
	// roles
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
	
	// avatar
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
	}

	public static User create(String login, String password, String email) {
		return new User(login, password, email);
	}

	public void assignCompany(Company company, boolean isOwner) {
		this.company = company;
		this.isOwner = isOwner;
	}

	public void update(String from) {
		this.from = from;
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
