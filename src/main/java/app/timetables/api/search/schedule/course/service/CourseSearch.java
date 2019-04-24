package app.timetables.api.search.schedule.course.service;

import app.timetables.api.schedule.domain.Course;
import app.timetables.api.search.schedule.course.CourseSearchQuery;
import app.timetables.api.search.schedule.course.service.graph.Graph;
import app.timetables.api.search.schedule.course.service.graph.GraphBuilderInterface;
import app.timetables.api.search.schedule.course.service.graph.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

        findAllPaths(startNode, endNode, graph);

        return courses;
    }

    private void findAllPaths(Node startNode, Node endNode, Graph graph) {
        Map<Long, Boolean> visited = new HashMap<>(graph.getSize());
        List<Long> pathList = new ArrayList<>();

        pathList.add(startNode.getId());
        aggregatePaths(startNode, endNode, visited, pathList);
    }

    private void aggregatePaths(
        Node startNode,
        Node endNode,
        Map<Long, Boolean> visited,
        List<Long> pathList
    ) {
        visited.put(startNode.getId(), true);

        if (startNode.equals(endNode)) {
            visited.put(startNode.getId(), false);
            System.out.println(pathList);
            return;
        }

        for (Node node : startNode.getNearbyNodes()) {
            if (visited.containsKey(node.getId())) {
                continue;
            }

            pathList.add(node.getId());
            aggregatePaths(node, endNode, visited, pathList);
            pathList.remove(node.getId());
        }

        visited.put(startNode.getId(), false);
    }

    private boolean validate(Node startNode, Node endNode) {
        return startNode == null || endNode == null;
    }

    private Graph buildGraph() {
        return graphBuilder.build(coursePartsProvider.get());
    }

}
