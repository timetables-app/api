package app.timetables.api.search.schedule.course.service;

import app.timetables.api.schedule.domain.CoursePart;
import java.util.List;

interface CoursePartsProviderInterface {

    public List<CoursePart> get();

}
