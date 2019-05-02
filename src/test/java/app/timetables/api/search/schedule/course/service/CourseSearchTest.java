package app.timetables.api.search.schedule.course.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import app.timetables.api.schedule.domain.CoursePart;
import app.timetables.api.search.schedule.course.CourseSearchQuery;
import app.timetables.api.search.schedule.course.service.dataprovider.onecourse.OneCoursePart;
import app.timetables.api.search.schedule.course.service.dataprovider.onecourse.ThreeCoursePart;
import app.timetables.api.search.schedule.course.service.dataprovider.onecourse.TwoCoursePart;
import app.timetables.api.search.schedule.course.service.dataprovider.threecourses.TwoComplexPaths;
import app.timetables.api.search.schedule.course.service.dataprovider.twocourses.OnePath;
import app.timetables.api.search.schedule.course.service.dataprovider.twocourses.OnePathTwoSameCourses;
import app.timetables.api.search.schedule.course.service.dataprovider.twocourses.TwoPaths;
import app.timetables.api.search.schedule.course.service.graph.GraphBuilder;
import app.timetables.api.search.schedule.course.service.result.CourseDto;
import app.timetables.api.search.schedule.course.service.result.CourseSearchResult;
import app.timetables.api.search.schedule.course.service.result.PlaceDto;
import java.time.LocalTime;
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
    public void testCourseSearchForNoPlaceInCoursePart() {
        List<CoursePart> coursePartList = OneCoursePart.get();
        Mockito.when(coursePartsProvider.get()).thenReturn(coursePartList);
        CourseSearchResult courseSearchResult = searchForPlaces(10L, 2L);

        assertTrue(courseSearchResult.getCourses().isEmpty());
    }

    @Test
    public void testCourseSearchForOneCoursePart() {
        List<CoursePart> coursePartList = OneCoursePart.get();
        Mockito.when(coursePartsProvider.get()).thenReturn(coursePartList);
        CourseSearchResult courseSearchResult = searchForPlaces(1L, 2L);

        numberOfFoundCourses(courseSearchResult, 1);
        numberOfPartsInCourse(courseSearchResult, 1L, 1);

        CourseDto courseDto = courseSearchResult.getCourses().get(1L);
        assertSame(1L, courseDto.getParts().get(1L).getCourse().getId());
        assertSame(2, courseDto.getParts().get(1L).getPlaces().size());
    }

    @Test
    public void testCourseSearchForTwoCoursePart() {
        List<CoursePart> coursePartList = TwoCoursePart.get();
        Mockito.when(coursePartsProvider.get()).thenReturn(coursePartList);
        CourseSearchResult courseSearchResult = searchForPlaces(1L, 3L);

        numberOfFoundCourses(courseSearchResult, 1);
        numberOfPartsInCourse(courseSearchResult, 1L, 1);

        CourseDto courseDto = courseSearchResult.getCourses().get(1L);
        assertSame(1L, courseDto.getParts().get(1L).getCourse().getId());
        assertSame(3, courseDto.getParts().get(1L).getPlaces().size());
    }

    @Test
    public void testCourseSearchForThreeCoursePart() {
        List<CoursePart> coursePartList = ThreeCoursePart.get();
        Mockito.when(coursePartsProvider.get()).thenReturn(coursePartList);
        CourseSearchResult courseSearchResult = searchForPlaces(1L, 4L);

        numberOfFoundCourses(courseSearchResult, 1);
        numberOfPartsInCourse(courseSearchResult, 1L, 1);

        CourseDto courseDto = courseSearchResult.getCourses().get(1L);
        assertSame(1L, courseDto.getParts().get(1L).getCourse().getId());
        assertSame(4, courseDto.getParts().get(1L).getPlaces().size());
    }

    @Test
    public void testCourseSearchForTwoCourses_TwoPaths_1_4() {
        List<CoursePart> coursePartList = TwoPaths.get();
        Mockito.when(coursePartsProvider.get()).thenReturn(coursePartList);
        CourseSearchResult courseSearchResult = searchForPlaces(1L, 4L);

        numberOfFoundCourses(courseSearchResult, 2);
        numberOfPartsInCourse(courseSearchResult, 1L, 1);
        numberOfPartsInCourse(courseSearchResult, 2L, 1);

        CourseDto courseDto1 = courseSearchResult.getCourses().get(1L);
        List<PlaceDto> places1 = courseDto1.getParts().get(1L).getPlaces();
        assertSame(1L, courseDto1.getParts().get(1L).getCourse().getId());
        assertSame(3, places1.size());

        assertEquals(LocalTime.of(7, 0), places1.get(0).getTime());
        assertEquals(LocalTime.of(7, 15), places1.get(1).getTime());
        assertEquals(LocalTime.of(7, 20), places1.get(2).getTime());

        CourseDto courseDto2 = courseSearchResult.getCourses().get(2L);
        List<PlaceDto> places2 = courseDto2.getParts().get(2L).getPlaces();
        assertSame(2L, courseDto2.getParts().get(2L).getCourse().getId());
        assertSame(3, courseDto2.getParts().get(2L).getPlaces().size());

        assertEquals(LocalTime.of(7, 0), places2.get(0).getTime());
        assertEquals(LocalTime.of(7, 15), places2.get(1).getTime());
        assertEquals(LocalTime.of(7, 40), places2.get(2).getTime());
    }

    @Test
    public void testCourseSearchForTwoCourses_TwoPaths_3_4() {
        List<CoursePart> coursePartList = TwoPaths.get();
        Mockito.when(coursePartsProvider.get()).thenReturn(coursePartList);
        CourseSearchResult courseSearchResult = searchForPlaces(3L, 4L);

        numberOfFoundCourses(courseSearchResult, 1);
        numberOfPartsInCourse(courseSearchResult, 2L, 1);

        CourseDto courseDto1 = courseSearchResult.getCourses().get(2L);
        List<PlaceDto> places1 = courseDto1.getParts().get(2L).getPlaces();
        assertSame(2L, courseDto1.getParts().get(2L).getCourse().getId());
        assertSame(2, places1.size());

        assertEquals(LocalTime.of(7, 15), places1.get(0).getTime());
        assertEquals(LocalTime.of(7, 40), places1.get(1).getTime());
    }

    @Test
    public void testCourseSearchForTwoCourses_OnePath_1_4() {
        List<CoursePart> coursePartList = OnePath.get();
        Mockito.when(coursePartsProvider.get()).thenReturn(coursePartList);
        CourseSearchResult courseSearchResult = searchForPlaces(1L, 4L);

        numberOfFoundCourses(courseSearchResult, 1);
        numberOfPartsInCourse(courseSearchResult, 1L, 1);

        CourseDto courseDto1 = courseSearchResult.getCourses().get(1L);
        List<PlaceDto> places1 = courseDto1.getParts().get(1L).getPlaces();
        assertSame(1L, courseDto1.getParts().get(1L).getCourse().getId());
        assertSame(3, places1.size());

        assertEquals(LocalTime.of(8, 0), places1.get(0).getTime());
        assertEquals(LocalTime.of(8, 15), places1.get(1).getTime());
        assertEquals(LocalTime.of(8, 20), places1.get(2).getTime());
    }

    @Test
    public void testCourseSearchForTwoCourses_OnePath_3_5() {
        List<CoursePart> coursePartList = OnePath.get();
        Mockito.when(coursePartsProvider.get()).thenReturn(coursePartList);
        CourseSearchResult courseSearchResult = searchForPlaces(3L, 5L);

        numberOfFoundCourses(courseSearchResult, 1);
        numberOfPartsInCourse(courseSearchResult, 2L, 1);

        CourseDto courseDto1 = courseSearchResult.getCourses().get(2L);
        List<PlaceDto> places1 = courseDto1.getParts().get(2L).getPlaces();
        assertSame(2L, courseDto1.getParts().get(2L).getCourse().getId());
        assertSame(3, places1.size());

        assertEquals(LocalTime.of(8, 4), places1.get(0).getTime());
        assertEquals(LocalTime.of(8, 12), places1.get(1).getTime());
        assertEquals(LocalTime.of(8, 30), places1.get(2).getTime());
    }

    @Test
    public void testCourseSearchForTwoCourses_OnePathTwoSameCourses() {
        List<CoursePart> coursePartList = OnePathTwoSameCourses.get();
        Mockito.when(coursePartsProvider.get()).thenReturn(coursePartList);
        CourseSearchResult courseSearchResult = searchForPlaces(1L, 4L);

        numberOfFoundCourses(courseSearchResult, 2);
        numberOfPartsInCourse(courseSearchResult, 1L, 1);
        numberOfPartsInCourse(courseSearchResult, 2L, 1);

        CourseDto courseDto1 = courseSearchResult.getCourses().get(1L);
        List<PlaceDto> places1 = courseDto1.getParts().get(1L).getPlaces();
        assertSame(1L, courseDto1.getParts().get(1L).getCourse().getId());
        assertSame(4, places1.size());

        assertEquals(LocalTime.of(8, 0), places1.get(0).getTime());
        assertEquals(LocalTime.of(8, 15), places1.get(1).getTime());
        assertEquals(LocalTime.of(8, 20), places1.get(2).getTime());
        assertEquals(LocalTime.of(8, 30), places1.get(3).getTime());

        CourseDto courseDto2 = courseSearchResult.getCourses().get(2L);
        List<PlaceDto> places2 = courseDto2.getParts().get(2L).getPlaces();
        assertSame(2L, courseDto2.getParts().get(2L).getCourse().getId());
        assertSame(4, places2.size());

        assertEquals(LocalTime.of(8, 10), places2.get(0).getTime());
        assertEquals(LocalTime.of(8, 25), places2.get(1).getTime());
        assertEquals(LocalTime.of(8, 30), places2.get(2).getTime());
        assertEquals(LocalTime.of(8, 40), places2.get(3).getTime());
    }

    @Test
    public void testCourseSearchForThreeCourses_TwoComplexPaths() {
        List<CoursePart> coursePartList = TwoComplexPaths.get();
        Mockito.when(coursePartsProvider.get()).thenReturn(coursePartList);
        CourseSearchResult courseSearchResult = searchForPlaces(1L, 4L);

        numberOfFoundCourses(courseSearchResult, 1);
        numberOfPartsInCourse(courseSearchResult, 1L, 1);

        CourseDto courseDto1 = courseSearchResult.getCourses().get(1L);
        List<PlaceDto> places1 = courseDto1.getParts().get(1L).getPlaces();
        assertSame(1L, courseDto1.getParts().get(1L).getCourse().getId());
        assertSame(3, places1.size());

        assertSame(1L, places1.get(0).getPlace().getId());
        assertSame(2L, places1.get(1).getPlace().getId());
        assertSame(4L, places1.get(2).getPlace().getId());

        assertEquals(LocalTime.of(8, 0), places1.get(0).getTime());
        assertEquals(LocalTime.of(8, 15), places1.get(1).getTime());
        assertEquals(LocalTime.of(8, 20), places1.get(2).getTime());
    }


    private void numberOfPartsInCourse(
        CourseSearchResult courseSearchResult,
        long index,
        int number
    ) {
        assertSame(number, courseSearchResult.getCourses().get(index).getParts().size());
    }

    private CourseSearchResult searchForPlaces(long startPlace, long endPlace) {
        CourseSearchQuery courseSearchQuery = new CourseSearchQuery(startPlace, endPlace);
        return courseSearch.search(courseSearchQuery);
    }

    private void numberOfFoundCourses(CourseSearchResult courseSearchResult, int i) {
        assertEquals(i, courseSearchResult.getCourses().size());
    }
}