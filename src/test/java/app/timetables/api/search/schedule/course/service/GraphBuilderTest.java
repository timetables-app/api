package app.timetables.api.search.schedule.course.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import app.timetables.api.search.schedule.course.service.dataprovider.onecourse.OneCoursePart;
import app.timetables.api.search.schedule.course.service.dataprovider.onecourse.TwoCoursePart;
import app.timetables.api.search.schedule.course.service.dataprovider.threecourses.TwoComplexPaths;
import app.timetables.api.search.schedule.course.service.dataprovider.twocourses.OnePath;
import app.timetables.api.search.schedule.course.service.dataprovider.twocourses.OnePathTwoSameCourses;
import app.timetables.api.search.schedule.course.service.dataprovider.twocourses.TwoPaths;
import app.timetables.api.search.schedule.course.service.graph.Graph;
import app.timetables.api.search.schedule.course.service.graph.GraphBuilder;
import app.timetables.api.search.schedule.course.service.graph.GraphBuilderInterface;
import app.timetables.api.search.schedule.course.service.graph.Node;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class GraphBuilderTest {

    private GraphBuilderInterface graphBuilder;

    @Before
    public void setUp() {
        graphBuilder = new GraphBuilder();
    }

    @Test
    public void testGraphBuildForOneCoursePart_Size() {
        Graph graph = graphBuilder.build(OneCoursePart.getFirstCourseParts());

        assertSame(2, graph.getSize());
    }

    @Test
    public void testGraphBuildForOneCoursePart_Connection() {
        Graph graph = graphBuilder.build(OneCoursePart.getFirstCourseParts());

        Node node1 = graph.getNode(1L);
        assertNearbyNode(node1, graph.getNode(2L));

        Node node2 = graph.getNode(2L);
        assertTrue(node2.getNearbyNodes().isEmpty());

        assertSame(1, graph.getNode(1L).getCoursePartsForPlace(2L).size());
    }

    @Test
    public void testGraphBuildForTwoCoursePart_Size() {
        Graph graph = graphBuilder.build(TwoCoursePart.getFirstCourseParts());

        assertSame(3, graph.getSize());
    }

    @Test
    public void testGraphBuildForTwoCoursePart_Connections() {
        Graph graph = graphBuilder.build(TwoCoursePart.getFirstCourseParts());

        Node node1 = graph.getNode(1L);
        assertNearbyNode(node1, graph.getNode(2L));

        Node node2 = graph.getNode(2L);
        assertNearbyNode(node2, graph.getNode(3L));

        Node node3 = graph.getNode(3L);
        assertTrue(node3.getNearbyNodes().isEmpty());

        assertSame(1, graph.getNode(1L).getCoursePartsForPlace(2L).size());
        assertSame(1, graph.getNode(2L).getCoursePartsForPlace(3L).size());
    }

    @Test
    public void testGraphBuildForTwoCourses_Size() {
        Graph graph = graphBuilder.build(TwoPaths.get());

        assertSame(4, graph.getSize());
    }

    @Test
    public void testGraphBuildForTwoCourses_Connections() {
        Graph graph = graphBuilder.build(TwoPaths.get());

        Node node1 = graph.getNode(1L);
        assertNearbyNode(node1, graph.getNode(2L), graph.getNode(3L));

        Node node2 = graph.getNode(2L);
        assertNearbyNode(node2, graph.getNode(4L));

        Node node3 = graph.getNode(3L);
        assertNearbyNode(node3, graph.getNode(4L));

        Node node4 = graph.getNode(4L);
        assertTrue(node4.getNearbyNodes().isEmpty());

        assertSame(1, graph.getNode(1L).getCoursePartsForPlace(2L).size());
        assertSame(1, graph.getNode(1L).getCoursePartsForPlace(3L).size());
        assertSame(1, graph.getNode(2L).getCoursePartsForPlace(4L).size());
        assertSame(1, graph.getNode(3L).getCoursePartsForPlace(4L).size());
    }

    @Test
    public void testGraphBuildForTwoCoursesOnePath_Size() {
        Graph graph = graphBuilder.build(OnePath.get());

        assertSame(5, graph.getSize());
    }

    @Test
    public void testGraphBuildForTwoCoursesOnePath_Connections() {
        Graph graph = graphBuilder.build(OnePath.get());

        Node node1 = graph.getNode(1L);
        assertNearbyNode(node1, graph.getNode(2L), graph.getNode(5L));

        Node node2 = graph.getNode(2L);
        assertNearbyNode(node2, graph.getNode(4L));

        Node node3 = graph.getNode(3L);
        assertNearbyNode(node3, graph.getNode(1L));

        Node node4 = graph.getNode(4L);
        assertTrue(node4.getNearbyNodes().isEmpty());

        Node node5 = graph.getNode(5L);
        assertTrue(node5.getNearbyNodes().isEmpty());

        assertSame(1, graph.getNode(1L).getCoursePartsForPlace(2L).size());
        assertSame(1, graph.getNode(1L).getCoursePartsForPlace(5L).size());

        assertSame(1, graph.getNode(2L).getCoursePartsForPlace(4L).size());
        assertSame(1, graph.getNode(3L).getCoursePartsForPlace(1L).size());
    }


    @Test
    public void testGraphBuildForTwoCoursesOnePathTwoSameCourses_Size() {
        Graph graph = graphBuilder.build(OnePathTwoSameCourses.get());

        assertSame(4, graph.getSize());
    }

    @Test
    public void testGraphBuildForTwoCoursesOnePathTwoSameCourses_Connections() {
        Graph graph = graphBuilder.build(OnePathTwoSameCourses.get());

        Node node1 = graph.getNode(1L);
        assertNearbyNode(node1, graph.getNode(2L));

        Node node2 = graph.getNode(2L);
        assertNearbyNode(node2, graph.getNode(3L));

        Node node3 = graph.getNode(3L);
        assertNearbyNode(node3, graph.getNode(4L));

        Node node4 = graph.getNode(4L);
        assertTrue(node4.getNearbyNodes().isEmpty());

        assertSame(2, graph.getNode(1L).getCoursePartsForPlace(2L).size());
        assertSame(2, graph.getNode(2L).getCoursePartsForPlace(3L).size());
        assertSame(2, graph.getNode(3L).getCoursePartsForPlace(4L).size());
    }

    @Test
    public void testGraphBuildForThreeCoursesTwoComplexPaths_Size() {
        Graph graph = graphBuilder.build(TwoComplexPaths.get());

        assertSame(7, graph.getSize());
    }

    @Test
    public void testGraphBuildForThreeCoursesTwoComplexPaths_Connections() {
        Graph graph = graphBuilder.build(TwoComplexPaths.get());

        Node node1 = graph.getNode(1L);
        assertNearbyNode(node1, graph.getNode(2L), graph.getNode(5L));

        Node node2 = graph.getNode(2L);
        assertNearbyNode(node2, graph.getNode(4L));

        Node node3 = graph.getNode(3L);
        assertNearbyNode(node3, graph.getNode(1L));

        Node node4 = graph.getNode(4L);
        assertNearbyNode(node4, graph.getNode(7L));

        Node node5 = graph.getNode(5L);
        assertNearbyNode(node5, graph.getNode(4L));

        Node node6 = graph.getNode(6L);
        assertNearbyNode(node6, graph.getNode(5L));

        Node node7 = graph.getNode(7L);
        assertTrue(node7.getNearbyNodes().isEmpty());

        assertSame(1, node1.getCoursePartsForPlace(2L).size());
        assertSame(1, node1.getCoursePartsForPlace(5L).size());

        assertSame(1, node2.getCoursePartsForPlace(4L).size());

        assertSame(1, node3.getCoursePartsForPlace(1L).size());

        assertSame(1, node4.getCoursePartsForPlace(7L).size());

        assertSame(1, node5.getCoursePartsForPlace(4L).size());

        assertSame(1, node6.getCoursePartsForPlace(5L).size());
    }


    private void assertNearbyNode(Node nodeToTest, Node... nodesArray) {
        List<Node> nodes = Arrays.asList(nodesArray);

        assertSame(nodes.size(), nodeToTest.getNearbyNodes().size());

        for (Node node : nodes) {
            assertTrue(nodeToTest.getNearbyNodes().contains(node));
        }
    }
}