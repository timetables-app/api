package app.timetables.api.aop;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import app.timetables.api.common.BusinessException;
import app.timetables.api.common.MessageTranslator;
import app.timetables.api.common.Response;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {
	private static final String JPA_ERROR = "JPA_ERROR";
	private static final String UNKNOWN_ERROR = "UNKNOWN_ERROR";

	@Autowired
	private MessageTranslator messageSource;
	
	@ResponseBody
	@ExceptionHandler(SQLException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Response<?> handleSqlException(SQLException ex, WebRequest request) {
		log.warn("SQL exception: ", ex);
		// TODO translate
		return Response.error(JPA_ERROR);
	}

	@ResponseBody
	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(HttpStatus.OK)
	public Response<?> handleBussinessException(BusinessException ex, WebRequest request) {
		log.warn("Encountered BusinessException with code: TODO");
		// TODO translate
		return Response.error(ex.getMessageCode());
	}

	@ResponseBody
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Response<?> handleOther(Exception ex, WebRequest request) {
		log.warn("Exception: ", ex);
		String message = messageSource.translate(UNKNOWN_ERROR);
		return Response.error(UNKNOWN_ERROR, message);
	}
}
