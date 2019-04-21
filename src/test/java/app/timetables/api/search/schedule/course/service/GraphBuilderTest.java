package app.timetables.api.search.schedule.course.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import app.timetables.api.search.schedule.course.service.dataprovider.OneCoursePart;
import app.timetables.api.search.schedule.course.service.graph.GraphBuilder;
import app.timetables.api.search.schedule.course.service.graph.GraphBuilderInterface;
import app.timetables.api.search.schedule.course.service.graph.Node;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GraphBuilderTest {

    private GraphBuilderInterface graphBuilder = new GraphBuilder();

    @Test
    public void testGraphBuildOneNode() throws NoSuchFieldException {
        Map<Long, Node> graph = graphBuilder.build(OneCoursePart.get());

        assertEquals(1, graph.get(1L).getCourses().size());
        assertEquals(1, graph.get(2L).getCourses().size());

        Node node1 = graph.get(1L);
        Node node2 = graph.get(2L);

        for (Node node : node1.getNearbyPlaces()) {
            assertSame(node2, node);
        }

        assertEquals(2, graph.size());
    }

}