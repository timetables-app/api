package app.timetables.api.search.schedule.course.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import app.timetables.api.search.schedule.course.service.dataprovider.onecourse.OneCoursePart;
import app.timetables.api.search.schedule.course.service.dataprovider.onecourse.TwoCoursePart;
import app.timetables.api.search.schedule.course.service.dataprovider.twocourses.TwoPaths;
import app.timetables.api.search.schedule.course.service.graph.Graph;
import app.timetables.api.search.schedule.course.service.graph.GraphBuilder;
import app.timetables.api.search.schedule.course.service.graph.GraphBuilderInterface;
import app.timetables.api.search.schedule.course.service.graph.Node;
import java.util.Arrays;
import java.util.Collections;
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
        Graph graph = graphBuilder.build(OneCoursePart.get());

        assertSame(2, graph.getSize());
    }

    @Test
    public void testGraphBuildForOneCoursePart_Connection() {
        Graph graph = graphBuilder.build(OneCoursePart.get());

        Node node1 = graph.getNode(1L);
        assertNearbyNode(node1, Collections.singletonList(graph.getNode(2L)));

        Node node2 = graph.getNode(2L);
        assertTrue(node2.getNearbyNodes().isEmpty());

        assertSame(1, graph.getNode(1L).getCoursePartsForPlace(2L).size());
    }

    @Test
    public void testGraphBuildForTwoCoursePart_Size() {
        Graph graph = graphBuilder.build(TwoCoursePart.get());

        assertSame(3, graph.getSize());
    }

    @Test
    public void testGraphBuildForTwoCoursePart_Connections() {
        Graph graph = graphBuilder.build(TwoCoursePart.get());

        Node node1 = graph.getNode(1L);
        assertNearbyNode(node1, Collections.singletonList(graph.getNode(2L)));

        Node node2 = graph.getNode(2L);
        assertNearbyNode(node2, Collections.singletonList(graph.getNode(3L)));

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
        assertNearbyNode(node1, Arrays.asList(graph.getNode(2L), graph.getNode(3L)));

        Node node2 = graph.getNode(2L);
        assertNearbyNode(node2, Collections.singletonList(graph.getNode(4L)));

        Node node3 = graph.getNode(3L);
        assertNearbyNode(node3, Collections.singletonList(graph.getNode(4L)));

        Node node4 = graph.getNode(4L);
        assertTrue(node4.getNearbyNodes().isEmpty());

        assertSame(1, graph.getNode(1L).getCoursePartsForPlace(2L).size());
        assertSame(1, graph.getNode(1L).getCoursePartsForPlace(3L).size());
        assertSame(1, graph.getNode(2L).getCoursePartsForPlace(4L).size());
        assertSame(1, graph.getNode(3L).getCoursePartsForPlace(4L).size());
    }

    private void assertNearbyNode(Node nodeToTest, List<Node> nodes) {
        assertSame(nodes.size(), nodeToTest.getNearbyNodes().size());

        for (Node node : nodes) {
            assertTrue(nodeToTest.getNearbyNodes().contains(node));
        }
    }
}