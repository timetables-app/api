package app.timetables.api.search.schedule.course;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CourseSearchQuery {

    private final Long startPlace;

    private final Long endPlace;

    private final LocalDateTime fromDate;

    private final LocalDateTime toDate;

}
