package app.timetables.api.search.schedule.course.service;

import app.timetables.api.search.schedule.course.service.graph.Graph;
import app.timetables.api.search.schedule.course.service.graph.Node;
import app.timetables.api.search.schedule.course.service.pathfinder.Path;
import java.util.List;

public interface PathFinderInterface {

    public List<Path> find(Node startNode, Node endNode, Graph graph);

}
