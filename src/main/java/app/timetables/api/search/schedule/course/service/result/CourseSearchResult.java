package app.timetables.api.search.schedule.course.service.result;

import app.timetables.api.schedule.domain.Course;
import app.timetables.api.schedule.domain.CoursePart;
import app.timetables.api.schedule.domain.Place;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CourseSearchResult {

    private List<CourseDto> courses = new ArrayList<>();

    public List<CourseDto> getCourses() {
        return courses;
    }

    public CourseDto createCourse() {
        CourseDto courseDto = new CourseDto();
        courses.add(courseDto);

        return courseDto;
    }

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

            public PlaceDto addPlace(Place place, LocalTime departureTime) {
                PlaceDto placeDto = new PlaceDto(place, departureTime);
                places.add(placeDto);
                return placeDto;
            }

            public class PlaceDto {

                private Place place;

                private LocalTime departureTime;

                public PlaceDto(Place place, LocalTime departureTime) {
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
        }
    }
}
