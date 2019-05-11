package app.timetables.api.schedule.service;

import app.timetables.api.schedule.domain.Course;
import app.timetables.api.schedule.domain.CourseProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(excerptProjection = CourseProjection.class)
@CrossOrigin
public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {
    @Query("select c from Course c where lower(c.line.number) like concat(lower(:q), '%')" +
            "or lower(c.line.vehicleType) like concat(lower(:q), '%')" +
            "or lower(c.timetable.supportedCompany.name) like concat(lower(:q), '%')")
    Page<Course> q(@Param("q") String q, Pageable pageable);
}
