package app.timetables.api.search.schedule.course.service.graph;

import app.timetables.api.schedule.domain.Course;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Node implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long id;

    private final Set<Course> courses = new HashSet<>();

    private final Set<Node> nearbyPlaces = new HashSet<>();

    public Node(Long id) {
        this.id = id;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public Set<Node> getNearbyPlaces() {
        return nearbyPlaces;
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
        return id.equals(node.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}