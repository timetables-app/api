package app.timetables.api.aop;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import app.timetables.api.common.BusinessException;
import app.timetables.api.common.GenericResponseDto;
import app.timetables.api.common.MessageTranslator;
import lombok.extern.slf4j.Slf4j;

/**
 * AOP component for intercepting exceptions and returning translated error message
 * @author kmrozowski
 *
 */
@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {
	private static final String JPA_ERROR = "JPA_ERROR";
	private static final String UNKNOWN_ERROR = "UNKNOWN_ERROR";
	private static final String UNSUPPORTED_METHOD= "UNSUPPORTED_METHOD";
	private static final String INCORRECT_BODY= "INCORRECT_BODY";
	
	@Autowired
	private MessageTranslator messageSource;
	
	/**
	 * SQL exception. Results with "unknown error" message and 500 status code.
	 * @param ex
	 * @param request
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(SQLException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public GenericResponseDto<?> handleSqlException(SQLException ex, WebRequest request) {
		log.warn("SQL exception: ", ex);
		String message = messageSource.translate(JPA_ERROR);
		return GenericResponseDto.error(JPA_ERROR, message);
	}

	/**
	 * Business exception. Results with translated message and 200 status code.
	 * @param ex
	 * @param request
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(HttpStatus.OK)
	public GenericResponseDto<?> handleBussinessException(BusinessException ex, WebRequest request) {
		log.warn("Encountered BusinessException with code: {}", ex.getMessageCode());
		String message = messageSource.translate(ex.getMessageCode());
		return GenericResponseDto.error(ex.getMessageCode(), message);
	}

	/**
	 * Wrong REST method used. Results in "unsupported method" message and 400 status code.
	 * @param ex
	 * @param request
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public GenericResponseDto<?> handleHttpMethodException(HttpRequestMethodNotSupportedException ex, WebRequest request) {
		log.warn("Exception: ", ex);
		String message = messageSource.translate(UNSUPPORTED_METHOD, new Object[] {ex.getMethod()});
		return GenericResponseDto.error(UNSUPPORTED_METHOD, message);
	}
	
	/**
	 * Wrong REST method used. Results in "incorrect body" message and 400 status code.
	 * @param ex
	 * @param request
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public GenericResponseDto<?> handlejsonException(HttpRequestMethodNotSupportedException ex, WebRequest request) {
		log.warn("Exception: ", ex);
		String message = messageSource.translate(INCORRECT_BODY);
		return GenericResponseDto.error(INCORRECT_BODY, message);
	}
	
	/**
	 * Exception not caught by previous method. Results in "unknown error" message and 500 status code.
	 * @param ex
	 * @param request
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public GenericResponseDto<?> handleOther(Exception ex, WebRequest request) {
		log.warn("Exception: ", ex);
		String message = messageSource.translate(UNKNOWN_ERROR);
		return GenericResponseDto.error(UNKNOWN_ERROR, message);
	}
}
