package app.timetables.api.schedule.service;

import app.timetables.api.schedule.domain.Course;
import app.timetables.api.schedule.domain.CoursePart;
import app.timetables.api.schedule.domain.CoursePartProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@RepositoryRestResource(excerptProjection = CoursePartProjection.class)
@CrossOrigin
public interface CoursePartRepository extends PagingAndSortingRepository<CoursePart, Long> {

    Iterable<CoursePart> findByCourse(Course course);

    @Query("select cp from CoursePart cp where lower(cp.source.name) like concat(lower(:q), '%')" +
            "or lower(cp.destination.name) like concat(lower(:q), '%')")
    Page<CoursePart> q(@Param("q") String q, Pageable pageable);
}
