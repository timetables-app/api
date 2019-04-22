package app.timetables.api.search.schedule.course.service.graph;

import app.timetables.api.schedule.domain.Course;
import app.timetables.api.schedule.domain.Place;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Graph implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Map<Long, Node> graph = new LinkedHashMap<>();

    public Map<Long, Node> get() {
        return graph;
    }

    public Node getNode(Long id) {
        return graph.get(id);
    }

    public void create(Course course, Place place) {
        Long placeId = place.getId();
        if (!graph.containsKey(placeId)) {
            graph.put(placeId, new Node(placeId));
        }

        graph.get(placeId).getCourses().add(course);
    }

    public void connect(Place source, Place destination) {
        Node sourceNode = graph.get(source.getId());
        Node destinationNode = graph.get(destination.getId());

        sourceNode.getNearbyPlaces().add(destinationNode);
    }


}
