package app.timetables.api.search.schedule.course.service;

import static org.junit.Assert.assertSame;

import app.timetables.api.search.schedule.course.service.dataprovider.onecourse.OneCoursePart;
import app.timetables.api.search.schedule.course.service.dataprovider.onecourse.ThreeCoursePart;
import app.timetables.api.search.schedule.course.service.dataprovider.onecourse.TwoCoursePart;
import app.timetables.api.search.schedule.course.service.dataprovider.threecourses.TwoComplexPaths;
import app.timetables.api.search.schedule.course.service.dataprovider.twocourses.OnePath;
import app.timetables.api.search.schedule.course.service.dataprovider.twocourses.TwoPaths;
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
    public void testFindPathForOneCoursePart() {
        Graph graph = graphBuilder.build(OneCoursePart.getFirstCourseParts());

        Node startNode = graph.getNode(1L);
        Node endNode = graph.getNode(2L);

        List<Path> foundPaths = pathFinder.find(startNode, endNode, graph);

        assertSame(1, foundPaths.size());
        assertSame(1L, foundPaths.get(0).getPoints().get(0));
        assertSame(2L, foundPaths.get(0).getPoints().get(1));
    }

    @Test
    public void testFindPathForTwoCoursePart() {
        Graph graph = graphBuilder.build(TwoCoursePart.getFirstCourseParts());

        Node startNode = graph.getNode(1L);
        Node endNode = graph.getNode(3L);

        List<Path> foundPaths = pathFinder.find(startNode, endNode, graph);

        assertSame(1, foundPaths.size());
        assertSame(1L, foundPaths.get(0).getPoints().get(0));
        assertSame(2L, foundPaths.get(0).getPoints().get(1));
        assertSame(3L, foundPaths.get(0).getPoints().get(2));
    }

    @Test
    public void testFindPathForThreeCoursePart() {
        Graph graph = graphBuilder.build(ThreeCoursePart.get());

        Node startNode = graph.getNode(1L);
        Node endNode = graph.getNode(4L);

        List<Path> foundPaths = pathFinder.find(startNode, endNode, graph);

        assertSame(1, foundPaths.size());
        assertSame(1L, foundPaths.get(0).getPoints().get(0));
        assertSame(2L, foundPaths.get(0).getPoints().get(1));
        assertSame(3L, foundPaths.get(0).getPoints().get(2));
        assertSame(4L, foundPaths.get(0).getPoints().get(3));
    }

    @Test
    public void testFindPathForTwoCourses_TwoPaths_1_4() {
        Graph graph = graphBuilder.build(TwoPaths.get());

        Node startNode = graph.getNode(1L);
        Node endNode = graph.getNode(4L);

        List<Path> foundPaths = pathFinder.find(startNode, endNode, graph);

        assertSame(2, foundPaths.size());

        assertSame(1L, foundPaths.get(0).getPoints().get(0));
        assertSame(2L, foundPaths.get(0).getPoints().get(1));
        assertSame(4L, foundPaths.get(0).getPoints().get(2));

        assertSame(1L, foundPaths.get(1).getPoints().get(0));
        assertSame(3L, foundPaths.get(1).getPoints().get(1));
        assertSame(4L, foundPaths.get(1).getPoints().get(2));
    }

    @Test
    public void testFindPathForTwoCourses_TwoPaths_3_4() {
        Graph graph = graphBuilder.build(TwoPaths.get());

        Node startNode = graph.getNode(3L);
        Node endNode = graph.getNode(4L);

        List<Path> foundPaths = pathFinder.find(startNode, endNode, graph);

        assertSame(1, foundPaths.size());

        assertSame(3L, foundPaths.get(0).getPoints().get(0));
        assertSame(4L, foundPaths.get(0).getPoints().get(1));
    }


    @Test
    public void testFindPathForTwoCourses_OnePath_1_4() {
        Graph graph = graphBuilder.build(OnePath.get());

        Node startNode = graph.getNode(1L);
        Node endNode = graph.getNode(4L);

        List<Path> foundPaths = pathFinder.find(startNode, endNode, graph);

        assertSame(1, foundPaths.size());

        assertSame(1L, foundPaths.get(0).getPoints().get(0));
        assertSame(2L, foundPaths.get(0).getPoints().get(1));
        assertSame(4L, foundPaths.get(0).getPoints().get(2));
    }

    @Test
    public void testFindPathForTwoCourses_OnePath_3_5() {
        Graph graph = graphBuilder.build(OnePath.get());

        Node startNode = graph.getNode(3L);
        Node endNode = graph.getNode(5L);

        List<Path> foundPaths = pathFinder.find(startNode, endNode, graph);

        assertSame(1, foundPaths.size());

        assertSame(3L, foundPaths.get(0).getPoints().get(0));
        assertSame(1L, foundPaths.get(0).getPoints().get(1));
        assertSame(5L, foundPaths.get(0).getPoints().get(2));
    }

    @Test
    public void testFindPathForThreeCourses_TwoComplexPaths() {
        Graph graph = graphBuilder.build(TwoComplexPaths.get());

        Node startNode = graph.getNode(1L);
        Node endNode = graph.getNode(4L);

        List<Path> foundPaths = pathFinder.find(startNode, endNode, graph);

        assertSame(2, foundPaths.size());

        assertSame(1L, foundPaths.get(0).getPoints().get(0));
        assertSame(2L, foundPaths.get(0).getPoints().get(1));
        assertSame(4L, foundPaths.get(0).getPoints().get(2));

        assertSame(1L, foundPaths.get(1).getPoints().get(0));
        assertSame(5L, foundPaths.get(1).getPoints().get(1));
        assertSame(4L, foundPaths.get(1).getPoints().get(2));
    }

}