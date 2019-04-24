package app.timetables.api.search.schedule.course.service.graph;

import app.timetables.api.schedule.domain.CoursePart;
import app.timetables.api.schedule.domain.Place;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Graph implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Map<Long, Node> nodes = new LinkedHashMap<>();

    public Node getNode(Long id) {
        return nodes.get(id);
    }

    public Integer getSize() {
        return nodes.size();
    }

    void create(Place place) {
        nodes.putIfAbsent(place.getId(), new Node(place));
    }

    void connect(CoursePart coursePart) {
        Node sourceNode = nodes.get(coursePart.getSource().getId());
        Node destinationNode = nodes.get(coursePart.getDestination().getId());

        sourceNode.addNearbyNode(destinationNode);
        sourceNode.addCoursePartForPlace(destinationNode, coursePart);
    }


}
