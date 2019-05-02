package app.timetables.api.schedule.service;

import app.timetables.api.schedule.domain.CoursePart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursePartRepository extends CrudRepository<CoursePart, Long> {

}
