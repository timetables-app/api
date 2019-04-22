package app.timetables.api.search.schedule.course.service;

import static org.junit.Assert.assertEquals;
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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class GraphBuilderTest {

    private GraphBuilderInterface graphBuilder = new GraphBuilder();

    @Test
    public void testGraphBuildForOneCoursePart() throws NoSuchFieldException {
        Graph graph = graphBuilder.build(OneCoursePart.get());

        assertEquals(1, graph.getNode(1L).getCourses().size());
        assertEquals(1, graph.getNode(2L).getCourses().size());

        Node node1 = graph.getNode(1L);
        assertTrue(graph.getNode(2L).getNearbyPlaces().isEmpty());

        assertNearbyNode(node1, Collections.singletonList(graph.getNode(2L)));

        assertEquals(2, graph.get().size());
    }

    @Test
    public void testGraphBuildForTwoCoursePart() throws NoSuchFieldException {
        Graph graph = graphBuilder.build(TwoCoursePart.get());

        assertEquals(1, graph.getNode(1L).getCourses().size());
        assertEquals(1, graph.getNode(2L).getCourses().size());
        assertEquals(1, graph.getNode(3L).getCourses().size());

        Node node1 = graph.getNode(1L);
        assertNearbyNode(node1, Collections.singletonList(graph.getNode(2L)));

        Node node2 = graph.getNode(2L);
        assertNearbyNode(node2, Collections.singletonList(graph.getNode(3L)));

        assertTrue(graph.getNode(3L).getNearbyPlaces().isEmpty());

        assertEquals(3, graph.get().size());
    }

    private void assertNearbyNode(Node nodeToTest, List<Node> nodes) {
        int i = 0;
        for (Node node : nodeToTest.getNearbyPlaces()) {
            assertSame(nodes.get(i), node);
            i++;
        }
    }
}