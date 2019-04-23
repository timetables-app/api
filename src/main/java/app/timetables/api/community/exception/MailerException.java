package app.timetables.api.community.exception;

import app.timetables.api.common.BusinessException;

public class MailerException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1141618830441376018L;

	public MailerException() {
		super("MAILER_EXCEPTION");
	}

}
