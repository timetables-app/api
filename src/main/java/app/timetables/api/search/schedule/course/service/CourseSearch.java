package app.timetables.api.search.schedule.course.service;

import app.timetables.api.schedule.domain.Course;
import app.timetables.api.search.schedule.course.CourseSearchQuery;
import app.timetables.api.search.schedule.course.service.graph.Graph;
import app.timetables.api.search.schedule.course.service.graph.GraphBuilderInterface;
import app.timetables.api.search.schedule.course.service.graph.Node;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseSearch {

    private CoursePartsProviderInterface coursePartsProvider;

    private GraphBuilderInterface graphBuilder;

    private List<Course> courses = new ArrayList<>();

    @Autowired
    public CourseSearch(
        CoursePartsProviderInterface coursePartsProvider,
        GraphBuilderInterface graphBuilder
    ) {
        this.coursePartsProvider = coursePartsProvider;
        this.graphBuilder = graphBuilder;
    }

    public List<Course> search(CourseSearchQuery courseSearchQuery) {
        Graph graph = buildGraph();
        Node startNode = graph.getNode(courseSearchQuery.getStartPlace());
        Node endNode = graph.getNode(courseSearchQuery.getEndPlace());

        if (validate(startNode, endNode)) {
            return courses;
        }


        return courses;
    }


    private boolean validate(Node startNode, Node endNode) {
        return startNode == null || endNode == null;
    }

    private Graph buildGraph() {
        return graphBuilder.build(coursePartsProvider.get());
    }

}
