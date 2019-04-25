package app.timetables.api.search.schedule.course.service.result;

import java.util.ArrayList;
import java.util.List;

public class CourseSearchResult {

    private List<CourseDto> courses = new ArrayList<>();

    public List<CourseDto> getCourses() {
        return courses;
    }

    public CourseDto createCourse() {
        CourseDto courseDto = new CourseDto();
        courses.add(courseDto);

        return courseDto;
    }

}
