package app.timetables.api.search.schedule.course.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import app.timetables.api.schedule.domain.CoursePart;
import app.timetables.api.search.schedule.course.CourseSearchQuery;
import app.timetables.api.search.schedule.course.service.dataprovider.OneCoursePart;
import app.timetables.api.search.schedule.course.service.dataprovider.TwoCoursePart;
import app.timetables.api.search.schedule.course.service.graph.GraphBuilder;
import app.timetables.api.search.schedule.course.service.result.CourseSearchResult;
import app.timetables.api.search.schedule.course.service.result.CourseSearchResult.CourseDto;
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
        courseSearch = new CourseSearch(coursePartsProvider, new GraphBuilder(), new PathFinder());
    }

    @Test
    public void testCourseSearch_NoPlaceInCoursePart() {
        List<CoursePart> coursePartList = OneCoursePart.get();
        Mockito.when(coursePartsProvider.get()).thenReturn(coursePartList);

        CourseSearchQuery courseSearchQuery = new CourseSearchQuery(10L, 2L);
        CourseSearchResult courseSearchResult = courseSearch.search(courseSearchQuery);

        assertTrue(courseSearchResult.getCourses().isEmpty());
    }

    @Test
    public void testCourseSearch_WithOneCoursePart() {
        List<CoursePart> coursePartList = OneCoursePart.get();
        Mockito.when(coursePartsProvider.get()).thenReturn(coursePartList);

        CourseSearchQuery courseSearchQuery = new CourseSearchQuery(1L, 2L);
        CourseSearchResult courseSearchResult = courseSearch.search(courseSearchQuery);

        CourseDto courseDto = courseSearchResult.getCourses().get(0);
        assertSame(1L, courseDto.getParts().get(1L).getCourse().getId());
        assertSame(2, courseDto.getParts().get(1L).getPlaces().size());
    }

    @Test
    public void testCourseSearch_WithTwoCoursePart() {
        List<CoursePart> coursePartList = TwoCoursePart.get();
        Mockito.when(coursePartsProvider.get()).thenReturn(coursePartList);

        CourseSearchQuery courseSearchQuery = new CourseSearchQuery(1L, 3L);
        CourseSearchResult courseSearchResult = courseSearch.search(courseSearchQuery);

        CourseDto courseDto = courseSearchResult.getCourses().get(0);
        assertSame(1L, courseDto.getParts().get(1L).getCourse().getId());
        assertSame(3, courseDto.getParts().get(1L).getPlaces().size());
    }
}