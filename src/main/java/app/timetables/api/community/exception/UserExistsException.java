package app.timetables.api.community.exception;

import app.timetables.api.common.BusinessException;

/**
 * Exception thrown when user tries to register, but user with specified email or login alr
 * @author kmrozowski
 *
 */
public class UserExistsException extends BusinessException {

	private static final long serialVersionUID = 6738566613228010359L;

	public UserExistsException() {
		super("USER_EXISTS");
	}

}
