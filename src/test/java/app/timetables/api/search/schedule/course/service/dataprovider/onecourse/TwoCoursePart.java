package app.timetables.api.search.schedule.course.service.dataprovider.onecourse;

import app.timetables.api.schedule.domain.Course;
import app.timetables.api.schedule.domain.CoursePart;
import app.timetables.api.schedule.domain.Place;
import app.timetables.api.schedule.domain.Timetable;
import app.timetables.api.search.schedule.course.service.dataprovider.PlaceCreator;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mockito.Mockito;

public class TwoCoursePart {

    public static List<CoursePart> getFirstCourseParts() {
        List<CoursePart> courseParts = new ArrayList<>();
        PlaceCreator placeCreator = new PlaceCreator();

        Course courseMock1 = getFirstCourse();

        Place place1 = placeCreator.getPlace(1L);
        Place place2 = placeCreator.getPlace(2L);
        Place place3 = placeCreator.getPlace(3L);

        CoursePart coursePart1 = Mockito.mock(CoursePart.class);
        Mockito.when(coursePart1.getId()).thenReturn(1L);
        Mockito.when(coursePart1.getSource()).thenReturn(place1);
        Mockito.when(coursePart1.getDestination()).thenReturn(place2);
        Mockito.when(coursePart1.getSourceTime()).thenReturn(LocalTime.of(7, 0));
        Mockito.when(coursePart1.getDestinationTime()).thenReturn(LocalTime.of(7, 15));
        Mockito.when(coursePart1.getCourse()).thenReturn(courseMock1);
        courseParts.add(coursePart1);

        CoursePart coursePart2 = Mockito.mock(CoursePart.class);
        Mockito.when(coursePart2.getId()).thenReturn(1L);
        Mockito.when(coursePart2.getSource()).thenReturn(place2);
        Mockito.when(coursePart2.getDestination()).thenReturn(place3);
        Mockito.when(coursePart2.getSourceTime()).thenReturn(LocalTime.of(7, 15));
        Mockito.when(coursePart2.getDestinationTime()).thenReturn(LocalTime.of(7, 20));
        Mockito.when(coursePart2.getCourse()).thenReturn(courseMock1);
        courseParts.add(coursePart2);

        return courseParts;
    }

    private static Course getFirstCourse() {
        Timetable timetableMock = Mockito.mock(Timetable.class);
        Mockito.when(timetableMock.getId()).thenReturn(1L);

        Course courseMock = Mockito.mock(Course.class);
        Mockito.when(courseMock.getId()).thenReturn(1L);
        Mockito.when(courseMock.getTimetable()).thenReturn(timetableMock);
        return courseMock;
    }


    public static List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();
        courses.add(getFirstCourse());

        return courses;
    }
}
