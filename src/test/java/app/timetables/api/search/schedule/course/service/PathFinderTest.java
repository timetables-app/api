package app.timetables.api.search.schedule.course.service;

import static org.junit.Assert.*;

import app.timetables.api.search.schedule.course.service.dataprovider.OneCoursePart;
import app.timetables.api.search.schedule.course.service.dataprovider.TwoCoursePart;
import app.timetables.api.search.schedule.course.service.graph.Graph;
import app.timetables.api.search.schedule.course.service.graph.GraphBuilder;
import app.timetables.api.search.schedule.course.service.graph.GraphBuilderInterface;
import app.timetables.api.search.schedule.course.service.graph.Node;
import app.timetables.api.search.schedule.course.service.pathfinder.Path;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class PathFinderTest {

    private GraphBuilderInterface graphBuilder;

    private PathFinderInterface pathFinder;

    @Before
    public void setUp() {
        graphBuilder = new GraphBuilder();
        pathFinder = new PathFinder();
    }

    @Test
    public void testPathForOneCoursePart() {
        Graph graph = graphBuilder.build(OneCoursePart.get());

        Node startNode = graph.getNode(1L);
        Node endNode = graph.getNode(2L);

        List<Path> foundPaths = pathFinder.find(startNode, endNode, graph);

        assertSame(1, foundPaths.size());
        assertSame(1L, foundPaths.get(0).getPoints().get(0));
        assertSame(2L, foundPaths.get(0).getPoints().get(1));
    }

    @Test
    public void testPathForTwoCoursePart() {
        Graph graph = graphBuilder.build(TwoCoursePart.get());

        Node startNode = graph.getNode(1L);
        Node endNode = graph.getNode(3L);

        List<Path> foundPaths = pathFinder.find(startNode, endNode, graph);

        assertSame(1, foundPaths.size());
        assertSame(1L, foundPaths.get(0).getPoints().get(0));
        assertSame(2L, foundPaths.get(0).getPoints().get(1));
        assertSame(3L, foundPaths.get(0).getPoints().get(2));
    }

}