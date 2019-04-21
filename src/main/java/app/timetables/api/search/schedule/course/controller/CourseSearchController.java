package app.timetables.api.search.schedule.course.controller;

import app.timetables.api.schedule.domain.Course;
import app.timetables.api.search.schedule.course.CourseSearchQuery;
import app.timetables.api.search.schedule.course.service.CourseSearch;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses/search")
public class CourseSearchController {

    @Autowired
    private CourseSearch courseSearch;

    @PostMapping
    public ResponseEntity<Iterable<Course>> search(@RequestBody CourseSearchQuery courseSearchQuery) {
        return ResponseEntity.of(Optional.of(courseSearch.search(courseSearchQuery)));
    }

}
