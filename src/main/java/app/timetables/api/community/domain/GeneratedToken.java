package app.timetables.api.community.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import app.timetables.api.common.EntityBase;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "GENERATED_TOKEN")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GeneratedToken extends EntityBase {
  
	/**
	 * Expiration time in hours.
	 */
    private static final int EXPIRATION = 24;

    @Column(name = "token")
    @Getter
    private String token;
  
    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    @Getter
    private User user;
  
    @Column(name = "expiration_date")
    private LocalDateTime expiryDate;
    
    public String getEmail() {
    	return user.getEmail().getValue();
    }
    
    public static GeneratedToken create(User user) {
    	GeneratedToken token = new GeneratedToken();
    	token.user = user;
    	token.expiryDate = LocalDateTime.now().plusHours(EXPIRATION);
    	token.token = UUID.randomUUID().toString();
    	return token;
    }
    
    public boolean isValid() {
    	return LocalDateTime.now().isBefore(expiryDate) && user != null;
    }
}
