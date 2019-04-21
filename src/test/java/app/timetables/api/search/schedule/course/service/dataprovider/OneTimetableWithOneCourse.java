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

public class OneTimetableWithOneCourse {

    private static final List<CoursePart> courseParts = new ArrayList<>();

    private static final Map<Long, Place> places = new HashMap<>();

    public static List<CoursePart> getCourseParts() throws NoSuchFieldException {
        Timetable timetableMock = Mockito.mock(Timetable.class);
        ReflectionTestUtils.setField(timetableMock, "id", 1L);

        Course courseMock = Mockito.mock(Course.class);
        ReflectionTestUtils.setField(courseMock, "id", 1L);
        ReflectionTestUtils.setField(courseMock, "timetable", timetableMock);

        CoursePart coursePart1 = Mockito.mock(CoursePart.class);
        ReflectionTestUtils.setField(coursePart1, "id", 1L);
        ReflectionTestUtils.setField(coursePart1, "source", getPlace(1L));
        ReflectionTestUtils.setField(coursePart1, "destination", getPlace(2L));
        ReflectionTestUtils.setField(coursePart1, "sourceTime", LocalTime.of(7, 0));
        ReflectionTestUtils.setField(coursePart1, "destinationTime", LocalTime.of(7, 15));
        ReflectionTestUtils.setField(coursePart1, "course", courseMock);
        courseParts.add(coursePart1);

        CoursePart coursePart2 = Mockito.mock(CoursePart.class);
        ReflectionTestUtils.setField(coursePart2, "id", 1L);
        ReflectionTestUtils.setField(coursePart2, "source", getPlace(2L));
        ReflectionTestUtils.setField(coursePart2, "destination", getPlace(3L));
        ReflectionTestUtils.setField(coursePart2, "sourceTime", LocalTime.of(7, 15));
        ReflectionTestUtils.setField(coursePart2, "destinationTime", LocalTime.of(7, 28));
        ReflectionTestUtils.setField(coursePart2, "course", courseMock);
        courseParts.add(coursePart2);

        CoursePart coursePart3 = Mockito.mock(CoursePart.class);
        ReflectionTestUtils.setField(coursePart3, "id", 1L);
        ReflectionTestUtils.setField(coursePart3, "source", getPlace(3L));
        ReflectionTestUtils.setField(coursePart3, "destination", getPlace(4L));
        ReflectionTestUtils.setField(coursePart3, "sourceTime", LocalTime.of(7, 28));
        ReflectionTestUtils.setField(coursePart3, "destinationTime", LocalTime.of(7, 35));
        ReflectionTestUtils.setField(coursePart3, "course", courseMock);
        courseParts.add(coursePart3);

        CoursePart coursePart4 = Mockito.mock(CoursePart.class);
        ReflectionTestUtils.setField(coursePart4, "id", 1L);
        ReflectionTestUtils.setField(coursePart4, "source", getPlace(4L));
        ReflectionTestUtils.setField(coursePart4, "destination", getPlace(5L));
        ReflectionTestUtils.setField(coursePart4, "sourceTime", LocalTime.of(7, 35));
        ReflectionTestUtils.setField(coursePart4, "destinationTime", LocalTime.of(7, 40));
        ReflectionTestUtils.setField(coursePart4, "course", courseMock);
        courseParts.add(coursePart4);

        return courseParts;
    }

    private static Place getPlace(Long id) {
        if (places.containsKey(id)) {
            return places.get(id);
        }

        Place place = Mockito.mock(Place.class);
        ReflectionTestUtils.setField(place, "id", id);
        ReflectionTestUtils.setField(place, "name", "Place: " + id.toString());

        places.put(id, place);

        return place;
    }

}
