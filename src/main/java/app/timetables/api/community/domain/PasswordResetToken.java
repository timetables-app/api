package app.timetables.api.community.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import app.timetables.api.common.EntityBase;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PasswordResetToken extends EntityBase {
  
	/**
	 * Expiration time in hours.
	 */
    private static final int EXPIRATION = 24;

    @Column(name = "token")
    private String token;
  
    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;
  
    @Column(name = "expiration_date")
    private LocalDateTime expiryDate;
    
    public String getEmail() {
    	return user.getEmail().getValue();
    }
    
    public String getToken() {
    	return token;
    }
    
    public static PasswordResetToken create(User user) {
    	PasswordResetToken token = new PasswordResetToken();
    	token.user = user;
    	token.expiryDate = LocalDateTime.now().plusHours(EXPIRATION);
    	token.token = UUID.randomUUID().toString();
    	return token;
    }
}
