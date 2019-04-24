package app.timetables.api.search.schedule.course.service.graph;

import app.timetables.api.schedule.domain.CoursePart;
import app.timetables.api.schedule.domain.Place;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Node implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Place place;

    private final Set<Node> nearbyNodes = new HashSet<>();

    private Map<Long, List<CoursePart>> coursePartsForPlace = new HashMap<>();

    public Node(Place place) {
        this.place = place;
    }

    public Long getId() {
        return place.getId();
    }

    public Set<Node> getNearbyNodes() {
        return nearbyNodes;
    }

    public void addNearbyNode(Node destinationNode) {
        nearbyNodes.add(destinationNode);
    }

    public List<CoursePart> getCoursePartsForPlace(Place place) {
        return getCourseParts(place.getId());
    }

    public List<CoursePart> getCoursePartsForPlace(Long id) {
        return getCourseParts(id);
    }

    private List<CoursePart> getCourseParts(Long id) {
        if (coursePartsForPlace.containsKey(id)) {
            return coursePartsForPlace.get(id);
        }

        return Collections.emptyList();
    }

    public void addCoursePartForPlace(Node destinationNode, CoursePart coursePart) {
        if (!coursePartsForPlace.containsKey(destinationNode.getId())) {
            coursePartsForPlace.put(destinationNode.getId(), new ArrayList<>());
        }

        coursePartsForPlace.get(destinationNode.getId()).add(coursePart);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node node = (Node) o;
        return place.equals(node.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(place);
    }
}