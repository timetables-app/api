package app.timetables.api.search.schedule.course.service;

import app.timetables.api.schedule.domain.Course;
import app.timetables.api.search.schedule.course.CourseSearchQuery;
import app.timetables.api.search.schedule.course.service.graph.Graph;
import app.timetables.api.search.schedule.course.service.graph.GraphBuilderInterface;
import app.timetables.api.search.schedule.course.service.graph.Node;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseSearch {

    @Autowired
    private CoursePartsProviderInterface coursePartsProvider;

    @Autowired
    private GraphBuilderInterface graphBuilder;

    private List<Course> courses;

    public List<Course> search(CourseSearchQuery courseSearchQuery) {
        Graph graph = buildGraph();
        Node startNode = graph.getNode(courseSearchQuery.getStartPlace());
        Node endNode = graph.getNode(courseSearchQuery.getEndPlace());

        if (validate(startNode, endNode)) {
            return courses;
        }

        for (Node node : startNode.getNearbyPlaces()) {
            if (node.equals(endNode)) {
                courses.addAll(node.getCourses());
            }
        }

        return null;
    }

    private boolean validate(Node startNode, Node endNode) {
        return startNode == null || endNode == null;
    }

    private Graph buildGraph() {
        return graphBuilder.build(coursePartsProvider.get());
    }

}
