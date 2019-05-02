package app.timetables.api.search.schedule.course.service.graph;

import app.timetables.api.schedule.domain.CoursePart;
import org.springframework.stereotype.Service;

@Service
public class GraphBuilder implements GraphBuilderInterface {

    private final Graph graph = new Graph();

    public Graph build(Iterable<CoursePart> coursePartList) {
        for (CoursePart coursePart : coursePartList) {
            graph.create(coursePart.getSource());
            graph.create(coursePart.getDestination());
            graph.connect(coursePart);
        }

        return graph;
    }

}
