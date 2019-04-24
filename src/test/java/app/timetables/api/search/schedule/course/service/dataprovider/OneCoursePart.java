package app.timetables.api.search.schedule.course.service.dataprovider;

import app.timetables.api.schedule.domain.Course;
import app.timetables.api.schedule.domain.CoursePart;
import app.timetables.api.schedule.domain.Place;
import app.timetables.api.schedule.domain.Timetable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

public class OneCoursePart {

    private static Map<Long, Place> places;

    public static List<CoursePart> get() {
        List<CoursePart> courseParts = new ArrayList<>();
        places = new HashMap<>();

        Timetable timetableMock = Mockito.mock(Timetable.class);
        Mockito.when(timetableMock.getId()).thenReturn(1L);

        Course courseMock = Mockito.mock(Course.class);
        Mockito.when(courseMock.getId()).thenReturn(1L);
        Mockito.when(courseMock.getTimetable()).thenReturn(timetableMock);

        Place place = getPlace(1L);
        Place place2 = getPlace(2L);

        CoursePart coursePart1 = Mockito.mock(CoursePart.class);
        Mockito.when(coursePart1.getId()).thenReturn(1L);
        Mockito.when(coursePart1.getSource()).thenReturn(place);
        Mockito.when(coursePart1.getDestination()).thenReturn(place2);
        Mockito.when(coursePart1.getSourceTime()).thenReturn(LocalTime.of(7, 0));
        Mockito.when(coursePart1.getDestinationTime()).thenReturn(LocalTime.of(7, 15));
        Mockito.when(coursePart1.getCourse()).thenReturn(courseMock);

        courseParts.add(coursePart1);

        return courseParts;
    }

    private static Place getPlace(Long id) {
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
