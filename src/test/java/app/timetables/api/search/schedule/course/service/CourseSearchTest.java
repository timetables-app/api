package app.timetables.api.search.schedule.course.service;

import static org.junit.Assert.assertEquals;

import app.timetables.api.schedule.domain.Course;
import app.timetables.api.schedule.domain.CoursePart;
import app.timetables.api.search.schedule.course.CourseSearchQuery;
import app.timetables.api.search.schedule.course.service.dataprovider.OneTimetableWithOneCourse;
import app.timetables.api.search.schedule.course.service.graph.GraphBuilderInterface;
import java.util.List;
import java.util.stream.Stream;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CourseSearchTest {

    @Mock
    private CoursePartsProviderInterface coursePartsProvider;

    @Mock
    private GraphBuilderInterface graphBuilder;

    @InjectMocks
    private CourseSearch courseSearch;

    @Before
    public void setUp() throws Exception {
        Mockito.when(coursePartsProvider.get()).thenReturn(OneTimetableWithOneCourse.get());
    }

    @Test
    public void testCourseSearch_WithOneCourse() {
        CourseSearchQuery courseSearchQuery = new CourseSearchQuery(1L, 5L);

        Iterable<Course> courseList = courseSearch.search(courseSearchQuery);

        assertEquals(1, Stream.of(courseList).count());
    }


}