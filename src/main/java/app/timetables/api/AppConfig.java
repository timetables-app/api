package app.timetables.api;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

/**
 * I18n configuration.
 * @author kmrozowski
 *
 */
@Configuration
public class AppConfig {
	/**
	 * .property files basenames.
	 */
	private static final String[] BASE_MESSAGE_SOURCE_NAMES = {"Exceptions", "Messages"};
	
	/**
	 * Locale resolver based on Accept-Language header. Defaults to English if no header value is specified.
	 * @return
	 */
    @Bean
    public LocaleResolver localeResolver() {
        LocaleResolver slr = new AcceptHeaderLocaleResolver();
        ((AcceptHeaderLocaleResolver) slr).setDefaultLocale(Locale.US);
        return slr;
    }

    /**
     * Message source, based on .property files with specified prefix.
     * @return
     */
    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource rs = new ResourceBundleMessageSource();
        rs.setBasenames(BASE_MESSAGE_SOURCE_NAMES);
        rs.setDefaultEncoding("UTF-8");
        rs.setUseCodeAsDefaultMessage(true);
        return rs;
    }
}