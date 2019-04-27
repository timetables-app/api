package app.timetables.api.search.schedule.course.service.dataprovider.onecourse;

import app.timetables.api.schedule.domain.Course;
import app.timetables.api.schedule.domain.CoursePart;
import app.timetables.api.schedule.domain.Place;
import app.timetables.api.schedule.domain.Timetable;
import app.timetables.api.search.schedule.course.service.dataprovider.PlaceCreator;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.mockito.Mockito;

public class OneCoursePart {

    public static List<CoursePart> get() {
        List<CoursePart> courseParts = new ArrayList<>();
        PlaceCreator placeCreator = new PlaceCreator();

        Timetable timetableMock = Mockito.mock(Timetable.class);
        Mockito.when(timetableMock.getId()).thenReturn(1L);

        Course courseMock = Mockito.mock(Course.class);
        Mockito.when(courseMock.getId()).thenReturn(1L);
        Mockito.when(courseMock.getTimetable()).thenReturn(timetableMock);

        Place place = placeCreator.getPlace(1L);
        Place place2 = placeCreator.getPlace(2L);

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


}
