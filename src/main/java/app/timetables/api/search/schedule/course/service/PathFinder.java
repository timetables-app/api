package app.timetables.api.search.schedule.course.service;

import app.timetables.api.search.schedule.course.service.graph.Graph;
import app.timetables.api.search.schedule.course.service.graph.Node;
import app.timetables.api.search.schedule.course.service.pathfinder.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class PathFinder implements PathFinderInterface {

    private final List<Path> foundPaths = new ArrayList<>();

    public List<Path> find(Node startNode, Node endNode, Graph graph) {
        Map<Long, Boolean> visited = new HashMap<>(graph.getSize());
        LinkedList<Long> localPath = new LinkedList<>();

        localPath.add(startNode.getId());
        aggregatePaths(startNode, endNode, visited, localPath);

        return foundPaths;
    }

    private void aggregatePaths(
        Node startNode,
        Node endNode,
        Map<Long, Boolean> visited,
        LinkedList<Long> localPath
    ) {
        visited.put(startNode.getId(), true);

        if (startNode.equals(endNode)) {
            visited.put(startNode.getId(), false);

            foundPaths.add(new Path(localPath));
            return;
        }

        for (Node node : startNode.getNearbyNodes()) {
            if (visited.getOrDefault(node.getId(), false)) {
                continue;
            }

            localPath.add(node.getId());
            aggregatePaths(node, endNode, visited, localPath);
            localPath.removeLast();
        }

        visited.put(startNode.getId(), false);
    }
}
