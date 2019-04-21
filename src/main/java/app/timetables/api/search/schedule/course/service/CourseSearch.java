package app.timetables.api.search.schedule.course.service;

import app.timetables.api.schedule.domain.Course;
import app.timetables.api.schedule.domain.CoursePart;
import app.timetables.api.schedule.domain.Place;
import app.timetables.api.search.schedule.course.CourseSearchQuery;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseSearch {

    @Autowired
    private CoursePartsProvider coursePartsProvider;

    private final Map<Long, Node> placesGraph = new LinkedHashMap<>();

    public Iterable<Course> search(CourseSearchQuery courseSearchQuery) {
        for (CoursePart coursePart : coursePartsProvider.get()) {
            createPlace(coursePart.getCourse(), coursePart.getSource());
            createPlace(coursePart.getCourse(), coursePart.getDestination());
            connect(coursePart.getSource(), coursePart.getDestination());
        }

        return null;
    }

    private void connect(Place source, Place destination) {
        Node sourceNode = placesGraph.get(source.getId());
        Node destinationNode = placesGraph.get(destination.getId());

        sourceNode.nearbyPlaces.add(destinationNode);
    }

    private void createPlace(Course course, Place place) {
        if (!placesGraph.containsKey(place.getId())) {
            placesGraph.put(place.getId(), new Node());
        }

        Node node = placesGraph.get(place.getId());
        node.courses.add(course);
    }

    private class Node {

        private final Set<Course> courses = new HashSet<>();

        private final Set<Node> nearbyPlaces = new HashSet<>();

    }
}
