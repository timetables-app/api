package app.timetables.api.search.schedule.course.service;

import app.timetables.api.schedule.domain.CoursePart;

interface CoursePartsProviderInterface {

    public Iterable<CoursePart> get();

}
