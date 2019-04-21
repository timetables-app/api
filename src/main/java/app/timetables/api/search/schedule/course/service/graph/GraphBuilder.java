package app.timetables.api.search.schedule.course.service.graph;

import app.timetables.api.schedule.domain.Course;
import app.timetables.api.schedule.domain.CoursePart;
import app.timetables.api.schedule.domain.Place;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class GraphBuilder implements GraphBuilderInterface {

    private final Map<Long, Node> graph = new LinkedHashMap<>();

    public Map<Long, Node> build(List<CoursePart> coursePartList) {
        for (CoursePart coursePart : coursePartList) {
            createPlace(coursePart.getCourse(), coursePart.getSource());
            createPlace(coursePart.getCourse(), coursePart.getDestination());
            connect(coursePart.getSource(), coursePart.getDestination());
        }

        return graph;
    }

    private void connect(Place source, Place destination) {
        Node sourceNode = graph.get(source.getId());
        Node destinationNode = graph.get(destination.getId());

        sourceNode.getNearbyPlaces().add(destinationNode);
    }

    private void createPlace(Course course, Place place) {
        if (!graph.containsKey(place.getId())) {
            graph.put(place.getId(), new Node());
        }

        Node node = graph.get(place.getId());
        node.getCourses().add(course);
    }

}
