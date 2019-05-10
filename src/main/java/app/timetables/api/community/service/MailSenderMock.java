package app.timetables.api.community.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import app.timetables.api.community.domain.GeneratedToken;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class MailSenderMock implements MailSender {
	
	@Value("#{servletContext.contextPath}")
    private String servletContextPath;
	
	private String mailSenderTitle = "LOL";
	
	private String resetPasswordSubject = "LOL";
	
	@Override
	public boolean sendCreateToken(GeneratedToken token) {
		String url = String.format("%s/users/register/user/confirm?token=%s", servletContextPath, token.getToken());
		SimpleMailMessage email = new SimpleMailMessage();
	    email.setSubject(resetPasswordSubject);
	    email.setText(url);
	    email.setTo(token.getEmail());
	    email.setFrom(mailSenderTitle);
	    
	    log.info(url);
	    
	    return true;
	}
	
	@Override
	public boolean sendResetPasswordToken(GeneratedToken token) {
		String url = String.format("%s/users/register/password/confirm?token=%s", servletContextPath, token.getToken());
		SimpleMailMessage email = new SimpleMailMessage();
	    email.setSubject(resetPasswordSubject);
	    email.setText(url);
	    email.setTo(token.getEmail());
	    email.setFrom(mailSenderTitle);
	    
	    log.info(url);
	    
	    return true;
	}
}
