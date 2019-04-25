package app.timetables.api.search.schedule.course.service.result;

import app.timetables.api.schedule.domain.Place;
import java.time.LocalTime;

public class PlaceDto {

    private Place place;

    private LocalTime departureTime;

    PlaceDto(Place place, LocalTime departureTime) {
        this.place = place;
        this.departureTime = departureTime;
    }

    public Place getPlace() {
        return place;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }
}