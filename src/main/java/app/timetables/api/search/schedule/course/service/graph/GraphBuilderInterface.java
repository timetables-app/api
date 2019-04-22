package app.timetables.api.search.schedule.course.service.graph;

import app.timetables.api.schedule.domain.CoursePart;
import java.util.List;

public interface GraphBuilderInterface {

    Graph build(List<CoursePart> coursePartList);

}
