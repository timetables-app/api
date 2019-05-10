package app.timetables.api.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Base class for business exceptions (user doesn't have permissions to delete company etc.)
 * @author kmrozowski
 *
 */
@AllArgsConstructor
@Getter
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 2101319813850978977L;
	
	private String messageCode;
}
