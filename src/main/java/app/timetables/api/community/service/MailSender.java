package app.timetables.api.community.service;

import app.timetables.api.community.domain.GeneratedToken;

public interface MailSender {
	
	public boolean sendCreateToken(GeneratedToken token);
	
	public boolean sendResetPasswordToken(GeneratedToken token);
	
}
