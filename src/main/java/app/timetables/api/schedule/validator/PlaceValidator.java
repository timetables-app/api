package app.timetables.api.schedule.validator;

import app.timetables.api.schedule.domain.Place;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("beforeCreatePlaceValidator")
public class PlaceValidator implements Validator {
    private final String NOT_BLANK_MSG = "Pole nie może być puste.";

    @Override
    public boolean supports(Class<?> clazz) {
        return Place.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "locality", NOT_BLANK_MSG);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", NOT_BLANK_MSG);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "capacity", NOT_BLANK_MSG);
        validateGeoCoordinate(errors, "lat", 90);
        validateGeoCoordinate(errors, "lng", 180);
    }

    private void validateGeoCoordinate(Errors errors, String field, int rangeBound) {
        Object anyLat = errors.getFieldValue(field);
        if (anyLat == null) {
            errors.rejectValue(field, NOT_BLANK_MSG);
            return;
        }

        double lat = Double.parseDouble(anyLat.toString());
        if (lat > rangeBound || lat < rangeBound * -1) {
            errors.rejectValue(field, String.format("Wartość musi być w przedziale [-%1$s;%1$s]", rangeBound));
        }
    }
}
