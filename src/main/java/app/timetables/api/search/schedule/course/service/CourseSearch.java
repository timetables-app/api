package app.timetables.api.search.schedule.course.service;

import app.timetables.api.schedule.domain.Course;
import app.timetables.api.schedule.domain.CoursePart;
import app.timetables.api.search.schedule.course.CourseSearchQuery;
import app.timetables.api.search.schedule.course.service.graph.Graph;
import app.timetables.api.search.schedule.course.service.graph.GraphBuilderInterface;
import app.timetables.api.search.schedule.course.service.graph.Node;
import app.timetables.api.search.schedule.course.service.pathfinder.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseSearch {

    private final CoursePartsProviderInterface coursePartsProvider;

    private final GraphBuilderInterface graphBuilder;

    private final PathFinderInterface pathFinder;

    private List<Course> courses = new ArrayList<>();

    @Autowired
    public CourseSearch(
        CoursePartsProviderInterface coursePartsProvider,
        GraphBuilderInterface graphBuilder,
        PathFinderInterface pathFinder
    ) {
        this.coursePartsProvider = coursePartsProvider;
        this.graphBuilder = graphBuilder;
        this.pathFinder = pathFinder;
    }

    public List<Course> search(CourseSearchQuery courseSearchQuery) {
        Graph graph = buildGraph();
        Node startNode = graph.getNode(courseSearchQuery.getStartPlace());
        Node endNode = graph.getNode(courseSearchQuery.getEndPlace());

        if (validate(startNode, endNode)) {
            return courses;
        }

        return createResult(pathFinder.find(startNode, endNode, graph), graph);
    }

    private List<Course> createResult(List<Path> paths, Graph graph) {
        for (Path path : paths) {
            List<Long> pathPoints = path.getPoints();
            Node startNode = graph.getNode(pathPoints.get(0));
            Node nextNode;
            for (int i = 1; i < pathPoints.size(); i++) {
                nextNode = graph.getNode(pathPoints.get(i));

                courses.addAll(startNode.getCoursePartsForPlace(nextNode.getId())
                    .stream()
                    .map(CoursePart::getCourse)
                    .collect(Collectors.toList()));
            }
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
