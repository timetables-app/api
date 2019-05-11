package app.timetables.api.schedule.service;

import app.timetables.api.schedule.domain.Locality;
import app.timetables.api.schedule.domain.LocalityProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(excerptProjection = LocalityProjection.class)
@CrossOrigin
interface LocalityRepository extends PagingAndSortingRepository<Locality, Long> {
    @Query("select l from Locality l where lower(l.name) like concat(lower(:q), '%')")
    Page<Locality> q(@Param("q") String q, Pageable pageable);
}
