package app.timetables.api.common;

import java.io.Serializable;

import lombok.Getter;

//TODO String -> ErrorDto
@Getter
public class Response<T> implements Serializable {

	private static final long serialVersionUID = -1111058197024949111L;

	private boolean success;
	private T value;
	private String error;
	private String description;
	
	private Response(boolean success, T response, String error) {
		this.success = success;
		this.value = response;
		this.error = error;
	}
	
	private Response(boolean success, T response, String error, String description) {
		this.success = success;
		this.value = response;
		this.error = error;
		this.description = description;
	}
	
	public static Response<Void> success() {
		return new Response<>(true, null, null);
	}
	
	public static <T> Response<T> success(T response) {
		return new Response<>(true, response, null);
	}
	
	public static <T> Response<T> error(String error) {
		return new Response<>(false, null, error);
	}
	
	public static <T> Response<T> error(String error, String description) {
		return new Response<>(false, null, error, description);
	}
	
}
