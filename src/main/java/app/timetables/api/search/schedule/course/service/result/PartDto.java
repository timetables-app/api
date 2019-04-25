package app.timetables.api.search.schedule.course.service.result;

import app.timetables.api.schedule.domain.Course;
import app.timetables.api.schedule.domain.Place;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

public class PartDto {

    private Course course;

    private List<PlaceDto> places = new LinkedList<>();

    PartDto(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public List<PlaceDto> getPlaces() {
        return places;
    }

    void addPlace(Place place, LocalTime departureTime) {
        PlaceDto placeDto = new PlaceDto(place, departureTime);
        places.add(placeDto);
    }

}