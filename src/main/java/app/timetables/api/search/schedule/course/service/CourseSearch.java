package app.timetables.api.search.schedule.course.service;

import app.timetables.api.schedule.domain.Course;
import app.timetables.api.schedule.domain.CoursePart;
import app.timetables.api.search.schedule.course.CourseSearchQuery;
import app.timetables.api.search.schedule.course.service.graph.Graph;
import app.timetables.api.search.schedule.course.service.graph.GraphBuilderInterface;
import app.timetables.api.search.schedule.course.service.graph.Node;
import app.timetables.api.search.schedule.course.service.pathfinder.Path;
import app.timetables.api.search.schedule.course.service.result.CourseSearchResult;
import app.timetables.api.search.schedule.course.service.result.CourseSearchResult.CourseDto;
import java.util.ArrayList;
import java.util.List;
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

    public CourseSearchResult search(CourseSearchQuery courseSearchQuery) {
        Graph graph = buildGraph();
        Node startNode = graph.getNode(courseSearchQuery.getStartPlace());
        Node endNode = graph.getNode(courseSearchQuery.getEndPlace());

        if (validate(startNode, endNode)) {
            return new CourseSearchResult();
        }

        return createResult(pathFinder.find(startNode, endNode, graph), graph);
    }

    private CourseSearchResult createResult(List<Path> paths, Graph graph) {
        CourseSearchResult courseSearchResult = new CourseSearchResult();

        for (Path path : paths) {
            CourseDto courseDto = courseSearchResult.createCourse();

            List<Long> pathPoints = path.getPoints();
            Node startNode = graph.getNode(pathPoints.get(0));
            Node nextNode;
            for (int i = 1; i < pathPoints.size(); i++) {
                nextNode = graph.getNode(pathPoints.get(i));

                for (CoursePart coursePart : startNode.getCoursePartsForPlace(nextNode.getId())) {
                    courseDto.createPart(coursePart);
                }

                startNode = nextNode;
            }
        }

        return courseSearchResult;
    }


    private boolean validate(Node startNode, Node endNode) {
        return startNode == null || endNode == null;
    }

    private Graph buildGraph() {
        return graphBuilder.build(coursePartsProvider.get());
    }

}
