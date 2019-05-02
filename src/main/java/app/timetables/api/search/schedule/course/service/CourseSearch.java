package app.timetables.api.search.schedule.course.service;

import app.timetables.api.schedule.domain.Course;
import app.timetables.api.schedule.domain.CoursePart;
import app.timetables.api.schedule.service.CoursePartRepository;
import app.timetables.api.schedule.service.CourseRepository;
import app.timetables.api.search.schedule.course.CourseSearchQuery;
import app.timetables.api.search.schedule.course.service.graph.Graph;
import app.timetables.api.search.schedule.course.service.graph.GraphBuilderInterface;
import app.timetables.api.search.schedule.course.service.graph.Node;
import app.timetables.api.search.schedule.course.service.pathfinder.Path;
import app.timetables.api.search.schedule.course.service.result.CourseDto;
import app.timetables.api.search.schedule.course.service.result.CourseSearchResult;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseSearch {

    private final GraphBuilderInterface graphBuilder;

    private final PathFinderInterface pathFinder;

    private final CourseRepository courseRepository;

    private final CoursePartRepository coursePartRepository;

    @Autowired
    public CourseSearch(
        GraphBuilderInterface graphBuilder,
        PathFinderInterface pathFinder,
        CourseRepository courseRepository,
        CoursePartRepository coursePartRepository
    ) {
        this.graphBuilder = graphBuilder;
        this.pathFinder = pathFinder;
        this.courseRepository = courseRepository;
        this.coursePartRepository = coursePartRepository;
    }

    public CourseSearchResult search(CourseSearchQuery courseSearchQuery) {
        CourseSearchResult courseSearchResult = new CourseSearchResult();
        for (Course course : courseRepository.findAll()) {
            Graph graph = graphBuilder.build(coursePartRepository.findByCourse(course));
            Node startNode = graph.getNode(courseSearchQuery.getStartPlace());
            Node endNode = graph.getNode(courseSearchQuery.getEndPlace());

            if (validate(startNode, endNode)) {
                continue;
            }

            createResult(pathFinder.find(startNode, endNode, graph), graph, courseSearchResult);
        }

        return courseSearchResult;
    }

    private void createResult(
        List<Path> paths,
        Graph graph,
        CourseSearchResult courseSearchResult
    ) {
        for (Path path : paths) {
            resolveCourses(graph, courseSearchResult, path);
        }
    }

    private void resolveCourses(Graph graph, CourseSearchResult courseSearchResult, Path path) {
        List<Long> pathPoints = path.getPoints();
        Node startNode = graph.getNode(pathPoints.get(0));
        Node nextNode;
        for (int i = 1; i < pathPoints.size(); i++) {
            nextNode = graph.getNode(pathPoints.get(i));
            createParts(courseSearchResult, startNode, nextNode);
            startNode = nextNode;
        }
    }

    private void createParts(
        CourseSearchResult courseSearchResult,
        Node startNode,
        Node nextNode
    ) {
        for (CoursePart coursePart : startNode.getCoursePartsForPlace(nextNode.getId())) {
            CourseDto courseDto = courseSearchResult.createCourse(coursePart.getCourse().getId());
            courseDto.createPart(coursePart);
        }
    }


    private boolean validate(Node startNode, Node endNode) {
        return startNode == null || endNode == null;
    }

}
