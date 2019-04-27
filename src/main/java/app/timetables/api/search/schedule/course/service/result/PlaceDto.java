package app.timetables.api.search.schedule.course.service.result;

import app.timetables.api.schedule.domain.Place;
import java.time.LocalTime;

public class PlaceDto {

    private Place place;

    private LocalTime time;

    PlaceDto(Place place, LocalTime time) {
        this.place = place;
        this.time = time;
    }

    public Place getPlace() {
        return place;
    }

    public LocalTime getTime() {
        return time;
    }
}