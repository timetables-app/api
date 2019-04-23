package app.timetables.api.common;

import java.io.Serializable;

import lombok.Getter;

//TODO String -> ErrorDto
@Getter
public class GenericResponse<T> implements Serializable {

	private static final long serialVersionUID = -1111058197024949111L;

	private boolean success;
	private T value;
	private String error;
	private String description;
	
	private GenericResponse(boolean success, T response, String error) {
		this.success = success;
		this.value = response;
		this.error = error;
	}
	
	private GenericResponse(boolean success, T response, String error, String description) {
		this.success = success;
		this.value = response;
		this.error = error;
		this.description = description;
	}
	
	public static GenericResponse<Void> success() {
		return new GenericResponse<>(true, null, null);
	}
	
	public static <T> GenericResponse<T> success(T response) {
		return new GenericResponse<>(true, response, null);
	}
	
	public static <T> GenericResponse<T> error(String error) {
		return new GenericResponse<>(false, null, error);
	}
	
	public static <T> GenericResponse<T> error(String error, String description) {
		return new GenericResponse<>(false, null, error, description);
	}
	
}
