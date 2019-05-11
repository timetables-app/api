package app.timetables.api.schedule.validator;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.validation.Validator;

import java.util.Map;

@Configuration
public class ValidatorEventRegister implements InitializingBean {

    private final
    ValidatingRepositoryEventListener validatingRepositoryEventListener;

    private final Map<String, Validator> validators;

    public ValidatorEventRegister(ValidatingRepositoryEventListener validatingRepositoryEventListener, Map<String, Validator> validators) {
        this.validatingRepositoryEventListener = validatingRepositoryEventListener;
        this.validators = validators;
    }

    @Override
    public void afterPropertiesSet() {
        for (Map.Entry<String, Validator> entry : validators.entrySet()) {
            if (!entry.getKey().startsWith("beforeCreate")) {
                continue;
            }
            validatingRepositoryEventListener.addValidator("beforeCreate", entry.getValue());
        }
    }
}
