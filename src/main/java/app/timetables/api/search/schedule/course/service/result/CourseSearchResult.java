package app.timetables.api.search.schedule.course.service.result;

import java.util.HashMap;
import java.util.Map;

public class CourseSearchResult {

    private Map<Long, CourseDto> courses = new HashMap<>();

    public Map<Long, CourseDto> getCourses() {
        return courses;
    }

    public CourseDto createCourse(Long id) {
        if (courses.containsKey(id)) {
            return courses.get(id);
        }

        CourseDto courseDto = new CourseDto();
        courses.put(id, courseDto);

        return courseDto;
    }

}
