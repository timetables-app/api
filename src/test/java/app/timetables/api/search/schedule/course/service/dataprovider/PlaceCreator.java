package app.timetables.api.search.schedule.course.service.dataprovider;

import app.timetables.api.schedule.domain.Place;
import java.util.HashMap;
import java.util.Map;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

public class PlaceCreator {

    private Map<Long, Place> places = new HashMap<>();

    public Place getPlace(Long id) {
        if (places.containsKey(id)) {
            return places.get(id);
        }

        Place place = Mockito.mock(Place.class);
        Mockito.when(place.getId()).thenReturn(id);
        Mockito.when(place.getName()).thenReturn("Place: " + id.toString());
        ReflectionTestUtils.setField(place, "id", id);
        ReflectionTestUtils.setField(place, "name", "Place: " + id.toString());

        places.put(id, place);

        return place;
    }

}
