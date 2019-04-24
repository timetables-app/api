package app.timetables.api.search.schedule.course.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import app.timetables.api.search.schedule.course.service.dataprovider.OneCoursePart;
import app.timetables.api.search.schedule.course.service.dataprovider.TwoCoursePart;
import app.timetables.api.search.schedule.course.service.graph.Graph;
import app.timetables.api.search.schedule.course.service.graph.GraphBuilder;
import app.timetables.api.search.schedule.course.service.graph.GraphBuilderInterface;
import app.timetables.api.search.schedule.course.service.graph.Node;
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
    public void setUp() throws Exception {
        graphBuilder = new GraphBuilder();
    }

    @Test
    public void testGraphBuildForOneCoursePart_Size() throws NoSuchFieldException {
        Graph graph = graphBuilder.build(OneCoursePart.get());

        assertSame(2, graph.getSize());
    }

    @Test
    public void testGraphBuildForOneCoursePart_Connection() throws NoSuchFieldException {
        Graph graph = graphBuilder.build(OneCoursePart.get());

        assertNearbyNode(graph.getNode(1L), Collections.singletonList(graph.getNode(2L)));
        assertTrue(graph.getNode(2L).getNearbyNodes().isEmpty());

        assertSame(1, graph.getNode(1L).getCoursePartsForPlace(2L).size());
    }

    @Test
    public void testGraphBuildForTwoCoursePart_Size() throws NoSuchFieldException {
        Graph graph = graphBuilder.build(TwoCoursePart.get());

        assertSame(3, graph.getSize());
    }

    @Test
    public void testGraphBuildForTwoCoursePart_Connections() throws NoSuchFieldException {
        Graph graph = graphBuilder.build(TwoCoursePart.get());

        Node node1 = graph.getNode(1L);
        assertNearbyNode(node1, Collections.singletonList(graph.getNode(2L)));

        Node node2 = graph.getNode(2L);
        assertNearbyNode(node2, Collections.singletonList(graph.getNode(3L)));

        assertTrue(graph.getNode(3L).getNearbyNodes().isEmpty());

        assertSame(1, graph.getNode(1L).getCoursePartsForPlace(2L).size());
        assertSame(1, graph.getNode(2L).getCoursePartsForPlace(3L).size());
    }

    private void assertNearbyNode(Node nodeToTest, List<Node> nodes) {
        int i = 0;
        for (Node node : nodeToTest.getNearbyNodes()) {
            assertSame(nodes.get(i), node);
            i++;
        }
    }
}