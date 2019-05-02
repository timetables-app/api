package app.timetables.api.search.schedule.course.service.result;

import app.timetables.api.schedule.domain.CoursePart;
import java.util.HashMap;
import java.util.Map;

public class CourseDto {

    private Map<Long, PartDto> parts = new HashMap<>();

    public Map<Long, PartDto> getParts() {
        return parts;
    }

    public void createPart(CoursePart coursePart) {
        Long courseId = coursePart.getCourse().getId();
        PartDto partDto;
        if (!parts.containsKey(courseId)) {
            partDto = new PartDto(coursePart.getCourse());
            partDto.addPlace(coursePart.getSource(), coursePart.getSourceTime());
            parts.put(courseId, partDto);
        }

        partDto = parts.get(courseId);
        partDto.addPlace(coursePart.getDestination(), coursePart.getDestinationTime());
    }


}