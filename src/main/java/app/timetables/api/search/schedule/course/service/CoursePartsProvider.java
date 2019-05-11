package app.timetables.api.search.schedule.course.service;

import app.timetables.api.schedule.domain.CoursePart;
import app.timetables.api.schedule.service.CoursePartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoursePartsProvider implements CoursePartsProviderInterface {

    @Autowired
    private CoursePartRepository coursePartRepository;

    public Iterable<CoursePart> get() {
        return coursePartRepository.findAll();
    }

}
