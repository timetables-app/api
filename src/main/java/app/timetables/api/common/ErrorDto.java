package app.timetables.api.common;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Dto class for holding error code and translation
 * @author kmrozowski
 *
 */
@AllArgsConstructor
@Getter
public class ErrorDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8266837148168819043L;
	
	private String error;
	private String description;
	
}
