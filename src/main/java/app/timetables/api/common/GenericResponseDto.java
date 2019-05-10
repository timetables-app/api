package app.timetables.api.common;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Class representing response entity that's capable of displaying either success value or translated error.
 * @author kmrozowski
 *
 * @param <T>
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GenericResponseDto<T> implements Serializable {

	private static final long serialVersionUID = -1111058197024949111L;

	private boolean success;
	private T value;
	private ErrorDto error;

	/**
	 * Void success.
	 * @return
	 */
	public static GenericResponseDto<Void> success() {
		return new GenericResponseDto<>(true, null, null);
	}
	
	/**
	 * Success
	 * @param <T>
	 * @param response
	 * @return
	 */
	public static <T> GenericResponseDto<T> success(T response) {
		return new GenericResponseDto<>(true, response, null);
	}

	/**
	 * Error
	 * @param <T>
	 * @param error
	 * @param description
	 * @return
	 */
	public static <T> GenericResponseDto<T> error(String error, String description) {
		return new GenericResponseDto<>(false, null, new ErrorDto(error, description));
	}
	
}
