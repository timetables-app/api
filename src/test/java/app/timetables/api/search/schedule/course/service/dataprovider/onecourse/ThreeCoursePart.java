package app.timetables.api.search.schedule.course.service.dataprovider.onecourse;

import app.timetables.api.schedule.domain.Course;
import app.timetables.api.schedule.domain.CoursePart;
import app.timetables.api.schedule.domain.Place;
import app.timetables.api.schedule.domain.Timetable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.mockito.Mockito;

public class ThreeCoursePart {

    public static List<CoursePart> get() {
        List<CoursePart> courseParts = new ArrayList<>();
        PlaceCreator placeCreator = new PlaceCreator();

        Timetable timetableMock1 = Mockito.mock(Timetable.class);
        Mockito.when(timetableMock1.getId()).thenReturn(1L);

        Course courseMock1 = Mockito.mock(Course.class);
        Mockito.when(courseMock1.getId()).thenReturn(1L);
        Mockito.when(courseMock1.getTimetable()).thenReturn(timetableMock1);

        Place place1 = placeCreator.getPlace(1L);
        Place place2 = placeCreator.getPlace(2L);
        Place place3 = placeCreator.getPlace(3L);
        Place place4 = placeCreator.getPlace(4L);

        CoursePart coursePart1 = Mockito.mock(CoursePart.class);
        Mockito.when(coursePart1.getId()).thenReturn(1L);
        Mockito.when(coursePart1.getSource()).thenReturn(place1);
        Mockito.when(coursePart1.getDestination()).thenReturn(place2);
        Mockito.when(coursePart1.getSourceTime()).thenReturn(LocalTime.of(7, 0));
        Mockito.when(coursePart1.getDestinationTime()).thenReturn(LocalTime.of(7, 15));
        Mockito.when(coursePart1.getCourse()).thenReturn(courseMock1);
        courseParts.add(coursePart1);

        CoursePart coursePart2 = Mockito.mock(CoursePart.class);
        Mockito.when(coursePart2.getId()).thenReturn(2L);
        Mockito.when(coursePart2.getSource()).thenReturn(place2);
        Mockito.when(coursePart2.getDestination()).thenReturn(place3);
        Mockito.when(coursePart2.getSourceTime()).thenReturn(LocalTime.of(7, 15));
        Mockito.when(coursePart2.getDestinationTime()).thenReturn(LocalTime.of(7, 20));
        Mockito.when(coursePart2.getCourse()).thenReturn(courseMock1);
        courseParts.add(coursePart2);

        CoursePart coursePart3 = Mockito.mock(CoursePart.class);
        Mockito.when(coursePart3.getId()).thenReturn(3L);
        Mockito.when(coursePart3.getSource()).thenReturn(place3);
        Mockito.when(coursePart3.getDestination()).thenReturn(place4);
        Mockito.when(coursePart3.getSourceTime()).thenReturn(LocalTime.of(7, 20));
        Mockito.when(coursePart3.getDestinationTime()).thenReturn(LocalTime.of(7, 25));
        Mockito.when(coursePart3.getCourse()).thenReturn(courseMock1);
        courseParts.add(coursePart3);

        return courseParts;
    }


}
