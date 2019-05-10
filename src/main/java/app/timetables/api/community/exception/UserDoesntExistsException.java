package app.timetables.api.community.exception;

import app.timetables.api.common.BusinessException;

/**
 * Exception thrown when user tries to register, but user with specified login or email already exists.
 * @author kmrozowski
 *
 */
public class UserDoesntExistsException extends BusinessException {

	private static final long serialVersionUID = 6738566613228010359L;

	public UserDoesntExistsException() {
		super("USER_DOESNT_EXIST");
	}

}
