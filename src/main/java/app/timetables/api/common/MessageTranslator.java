package app.timetables.api.common;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageTranslator {
	private static final String UNKNOWN = "UNKNOWN_MESSAGE";
	@Autowired
	private ResourceBundleMessageSource messageSource;
	
	public String translate(String msg) {
		Locale locale = LocaleContextHolder.getLocale();
		try {
			return messageSource.getMessage(msg, null, locale);
		} catch (NoSuchMessageException ex) {
			return UNKNOWN;
		}
	}
	
	public String translate(String msg, Object[] args) {
		Locale locale = LocaleContextHolder.getLocale();
		try {
			return messageSource.getMessage(msg, args, locale);
		} catch (NoSuchMessageException ex) {
			return UNKNOWN;
		}
	}
}
