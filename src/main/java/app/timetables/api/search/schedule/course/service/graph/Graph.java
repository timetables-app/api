package app.timetables.api.search.schedule.course.service.graph;

import app.timetables.api.schedule.domain.CoursePart;
import app.timetables.api.schedule.domain.Place;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Graph implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Map<Long, Node> graph = new LinkedHashMap<>();

    public Node getNode(Long id) {
        return graph.get(id);
    }

    public Integer getSize() {
        return graph.size();
    }

    public void create(Place place) {
        graph.putIfAbsent(place.getId(), new Node(place));
    }

    public void connect(CoursePart coursePart) {
        Node sourceNode = graph.get(coursePart.getSource().getId());
        Node destinationNode = graph.get(coursePart.getDestination().getId());

        sourceNode.addNearbyNode(destinationNode);
        sourceNode.addCoursePartForPlace(destinationNode, coursePart);
    }


}
