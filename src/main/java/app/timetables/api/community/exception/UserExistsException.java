package app.timetables.api.community.exception;

import app.timetables.api.common.BusinessException;

public class UserExistsException extends BusinessException {

	private static final long serialVersionUID = 6738566613228010359L;

	public UserExistsException() {
		super("USER_EXISTS");
	}

}
