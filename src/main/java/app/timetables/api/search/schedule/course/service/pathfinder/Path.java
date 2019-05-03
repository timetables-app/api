package app.timetables.api.search.schedule.course.service.pathfinder;

import java.util.List;
import java.util.stream.Collectors;

public class Path {

    private final List<Long> points;

    public Path(List<Long> points) {
        this.points = points.stream().map(Long::valueOf).collect(Collectors.toList());
    }

    public List<Long> getPoints() {
        return points;
    }
}
