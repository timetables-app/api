package app.timetables.api.schedule.validator;

import org.springframework.data.rest.core.RepositoryConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RepositoryConstraintViolationException.class})
    public ResponseEntity handleAccessDeniedException(Exception ex, WebRequest request) {

        RepositoryConstraintViolationException requestException = (RepositoryConstraintViolationException) ex;
        Map<String, String> errorMap = new HashMap<>();
        List<FieldError> errors = requestException.getErrors().getFieldErrors();

        for (FieldError err : errors) {
            errorMap.put(err.getField(), err.getCode());
        }

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(errorMap, responseHeaders, HttpStatus.BAD_REQUEST);
    }
}
