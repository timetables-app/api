package app.timetables.api.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 2101319813850978977L;
	
	private String messageCode;
}
