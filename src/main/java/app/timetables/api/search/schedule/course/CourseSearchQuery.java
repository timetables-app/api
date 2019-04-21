package app.timetables.api.search.schedule.course;

import java.time.LocalTime;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CourseSearchQuery {

    private final Long startPlace;

    private final Long endPlace;

    private final LocalTime fromTime;

    private final LocalTime toTime;

}
