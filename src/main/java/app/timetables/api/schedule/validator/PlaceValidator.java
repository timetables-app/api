package app.timetables.api.schedule.validator;

import app.timetables.api.schedule.domain.Place;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("beforeCreatePlaceValidator")
public class PlaceValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Place.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Place place = (Place) target;
        errors.rejectValue("lat", "Everything wrong");
    }
}
