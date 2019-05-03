package app.timetables.api.search.schedule.course.service.dataprovider.twocourses;

import app.timetables.api.schedule.domain.Course;
import app.timetables.api.schedule.domain.CoursePart;
import app.timetables.api.schedule.domain.Place;
import app.timetables.api.schedule.domain.Timetable;
import app.timetables.api.search.schedule.course.service.dataprovider.PlaceCreator;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.mockito.Mockito;

public class TwoPaths {

    public static List<CoursePart> get() {
        List<CoursePart> courseParts = new ArrayList<>();
        courseParts.addAll(getFirstCourseParts());
        courseParts.addAll(getSecondCourseParts());

        return courseParts;
    }

    public static List<CoursePart> getFirstCourseParts() {
        List<CoursePart> courseParts = new ArrayList<>();
        PlaceCreator placeCreator = new PlaceCreator();

        Course courseMock1 = getFirstCourse();

        Place place1 = placeCreator.getPlace(1L);
        Place place2 = placeCreator.getPlace(2L);
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
        Mockito.when(coursePart2.getDestination()).thenReturn(place4);
        Mockito.when(coursePart2.getSourceTime()).thenReturn(LocalTime.of(7, 15));
        Mockito.when(coursePart2.getDestinationTime()).thenReturn(LocalTime.of(7, 20));
        Mockito.when(coursePart2.getCourse()).thenReturn(courseMock1);
        courseParts.add(coursePart2);

        return courseParts;
    }

    public static List<CoursePart> getSecondCourseParts() {
        List<CoursePart> courseParts = new ArrayList<>();
        PlaceCreator placeCreator = new PlaceCreator();
        Course courseMock2 = getSecondCourse();

        Place place1 = placeCreator.getPlace(1L);
        Place place3 = placeCreator.getPlace(3L);
        Place place4 = placeCreator.getPlace(4L);

        CoursePart coursePart1 = Mockito.mock(CoursePart.class);
        Mockito.when(coursePart1.getId()).thenReturn(3L);
        Mockito.when(coursePart1.getSource()).thenReturn(place1);
        Mockito.when(coursePart1.getDestination()).thenReturn(place3);
        Mockito.when(coursePart1.getSourceTime()).thenReturn(LocalTime.of(7, 0));
        Mockito.when(coursePart1.getDestinationTime()).thenReturn(LocalTime.of(7, 15));
        Mockito.when(coursePart1.getCourse()).thenReturn(courseMock2);
        courseParts.add(coursePart1);

        CoursePart coursePart2 = Mockito.mock(CoursePart.class);
        Mockito.when(coursePart2.getId()).thenReturn(4L);
        Mockito.when(coursePart2.getSource()).thenReturn(place3);
        Mockito.when(coursePart2.getDestination()).thenReturn(place4);
        Mockito.when(coursePart2.getSourceTime()).thenReturn(LocalTime.of(7, 15));
        Mockito.when(coursePart2.getDestinationTime()).thenReturn(LocalTime.of(7, 40));
        Mockito.when(coursePart2.getCourse()).thenReturn(courseMock2);
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

    private static Course getSecondCourse() {
        Timetable timetableMock = Mockito.mock(Timetable.class);
        Mockito.when(timetableMock.getId()).thenReturn(1L);

        Course courseMock = Mockito.mock(Course.class);
        Mockito.when(courseMock.getId()).thenReturn(2L);
        Mockito.when(courseMock.getTimetable()).thenReturn(timetableMock);
        return courseMock;
    }

    public static List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();
        courses.add(getFirstCourse());
        courses.add(getSecondCourse());

        return courses;
    }
}
