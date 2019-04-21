package app.timetables.api.search.schedule.course.service.graph;

import app.timetables.api.schedule.domain.CoursePart;
import java.util.List;
import java.util.Map;

public interface GraphBuilderInterface {

    Map<Long, Node> build(List<CoursePart> coursePartList);

}
