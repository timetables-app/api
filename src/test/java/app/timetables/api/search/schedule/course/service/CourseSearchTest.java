package app.timetables.api.search.schedule.course.service;

import static org.junit.Assert.assertEquals;

import app.timetables.api.schedule.domain.Course;
import app.timetables.api.schedule.domain.CoursePart;
import app.timetables.api.search.schedule.course.CourseSearchQuery;
import app.timetables.api.search.schedule.course.service.dataprovider.OneCoursePart;
import app.timetables.api.search.schedule.course.service.graph.GraphBuilderInterface;
import java.util.List;
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
        List<CoursePart> coursePartList = OneCoursePart.get();
        Mockito.when(coursePartsProvider.get()).thenReturn(coursePartList);
    }

    @Test
    public void testCourseSearch_WithOneCourse() {
        CourseSearchQuery courseSearchQuery = new CourseSearchQuery(1L, 2L);
        List<Course> courseList = courseSearch.search(courseSearchQuery);

        Course course = courseList.get(0);
        assertEquals(1L, java.util.Optional.ofNullable(course.getId()));
    }


}