package app.timetables.api.search.schedule.course.service.graph;

import app.timetables.api.schedule.domain.Course;
import java.util.HashSet;
import java.util.Set;

public class Node {

    private final Set<Course> courses = new HashSet<>();

    private final Set<Node> nearbyPlaces = new HashSet<>();

    public Set<Course> getCourses() {
        return courses;
    }

    public Set<Node> getNearbyPlaces() {
        return nearbyPlaces;
    }
}