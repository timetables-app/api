package app.timetables.api.search.schedule.course.controller;

import app.timetables.api.search.schedule.course.CourseSearchQuery;
import app.timetables.api.search.schedule.course.service.CourseSearch;
import app.timetables.api.search.schedule.course.service.result.CourseSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses/search")
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
