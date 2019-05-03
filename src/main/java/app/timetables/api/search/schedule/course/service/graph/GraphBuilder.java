package app.timetables.api.search.schedule.course.service.graph;

import app.timetables.api.schedule.domain.CoursePart;
import org.springframework.stereotype.Service;

@Service
public class GraphBuilder implements GraphBuilderInterface {

    public Graph build(Iterable<CoursePart> coursePartList) {
        Graph graph = new Graph();
        for (CoursePart coursePart : coursePartList) {
            graph.create(coursePart.getSource());
            graph.create(coursePart.getDestination());
            graph.connect(coursePart);
        }

        return graph;
    }

}
