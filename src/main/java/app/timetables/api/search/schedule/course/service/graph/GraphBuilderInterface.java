package app.timetables.api.search.schedule.course.service.graph;

import app.timetables.api.schedule.domain.CoursePart;

public interface GraphBuilderInterface {

    Graph build(Iterable<CoursePart> coursePartList);

}
