package app.timetables.api.search.schedule.course.controller;

import app.timetables.api.search.schedule.course.CourseSearchQuery;
import app.timetables.api.search.schedule.course.service.CourseSearch;
import app.timetables.api.search.schedule.course.service.result.CourseSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses/search")
@CrossOrigin
public class CourseSearchController {

    @Autowired
    private CourseSearch courseSearch;

    @GetMapping
    public CourseSearchResult search(
        @RequestParam Long startPlace,
        @RequestParam Long endPlace
    ) {
        return courseSearch.search(new CourseSearchQuery(startPlace, endPlace));
    }

}
