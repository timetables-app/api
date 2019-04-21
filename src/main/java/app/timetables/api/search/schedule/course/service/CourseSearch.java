package app.timetables.api.search.schedule.course.service;

import app.timetables.api.schedule.domain.Course;
import app.timetables.api.search.schedule.course.CourseSearchQuery;
import app.timetables.api.search.schedule.course.service.graph.GraphBuilderInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseSearch {

    @Autowired
    private CoursePartsProviderInterface coursePartsProvider;

    @Autowired
    private GraphBuilderInterface graphBuilder;

    public Iterable<Course> search(CourseSearchQuery courseSearchQuery) {

        return null;
    }

}
