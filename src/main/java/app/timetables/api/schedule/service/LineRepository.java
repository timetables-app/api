package app.timetables.api.schedule.service;

import app.timetables.api.schedule.domain.Line;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin
interface LineRepository extends PagingAndSortingRepository<Line, Long> {

    @Query("select l from Line l where lower(l.number) like concat(lower(:q), '%')" +
            "or lower(l.vehicleType) like concat(lower(:q), '%')")
    Page<Line> q(@Param("q") String q, Pageable pageable);
}
