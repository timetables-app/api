package app.timetables.api.schedule.service;

import app.timetables.api.schedule.domain.Timetable;
import app.timetables.api.schedule.domain.TimetableProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(excerptProjection = TimetableProjection.class)
@CrossOrigin
interface TimetableRepository extends PagingAndSortingRepository<Timetable, Long> {

    @Query("select t from Timetable t where lower(t.supportedCompany.name) like concat(lower(:q), '%')")
    Page<Timetable> q(@Param("q") String q, Pageable pageable);
}
