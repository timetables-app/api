package app.timetables.api.search.schedule.course.service.graph;

import app.timetables.api.schedule.domain.CoursePart;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GraphBuilder implements GraphBuilderInterface {

    private final Graph graph = new Graph();

    public Graph build(List<CoursePart> coursePartList) {
        for (CoursePart coursePart : coursePartList) {
            graph.create(coursePart.getCourse(), coursePart.getSource());
            graph.create(coursePart.getCourse(), coursePart.getDestination());
            graph.connect(coursePart.getSource(), coursePart.getDestination());
        }

        return graph;
    }

}
