package app.timetables.api.search.schedule.course.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import app.timetables.api.schedule.domain.Course;
import app.timetables.api.schedule.domain.CoursePart;
import app.timetables.api.search.schedule.course.CourseSearchQuery;
import app.timetables.api.search.schedule.course.service.dataprovider.OneCoursePart;
import app.timetables.api.search.schedule.course.service.dataprovider.TwoCoursePart;
import app.timetables.api.search.schedule.course.service.graph.GraphBuilder;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CourseSearchTest {

    @Mock
    private CoursePartsProviderInterface coursePartsProvider;

    private CourseSearch courseSearch;

    @Before
    public void setUp() {
        courseSearch = new CourseSearch(coursePartsProvider, new GraphBuilder());
    }

    @Test
    public void testCourseSearch_NoPlaceInCoursePart() throws NoSuchFieldException {
        List<CoursePart> coursePartList = OneCoursePart.get();
        Mockito.when(coursePartsProvider.get()).thenReturn(coursePartList);

        CourseSearchQuery courseSearchQuery = new CourseSearchQuery(10L, 2L);
        List<Course> courseList = courseSearch.search(courseSearchQuery);

        assertTrue(courseList.isEmpty());
    }

    @Test
    public void testCourseSearch_WithOneCoursePart() throws NoSuchFieldException {
        List<CoursePart> coursePartList = OneCoursePart.get();
        Mockito.when(coursePartsProvider.get()).thenReturn(coursePartList);

        CourseSearchQuery courseSearchQuery = new CourseSearchQuery(1L, 2L);
        List<Course> courseList = courseSearch.search(courseSearchQuery);

        Course course = courseList.get(0);
        assertSame(1L, course.getId());
    }

    @Test
    public void testCourseSearch_WithTwoCoursePart() throws NoSuchFieldException {
        List<CoursePart> coursePartList = TwoCoursePart.get();
        Mockito.when(coursePartsProvider.get()).thenReturn(coursePartList);

        CourseSearchQuery courseSearchQuery = new CourseSearchQuery(1L, 3L);
        List<Course> courseList = courseSearch.search(courseSearchQuery);

//        Course course = courseList.get(0);
//        assertSame(1L, course.getId());
    }
}