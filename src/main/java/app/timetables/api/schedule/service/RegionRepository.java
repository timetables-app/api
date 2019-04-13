package app.timetables.api.schedule.service;

import app.timetables.api.schedule.domain.Region;
import app.timetables.api.schedule.domain.RegionProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(excerptProjection = RegionProjection.class)
@CrossOrigin
interface RegionRepository extends PagingAndSortingRepository<Region, Long> {

    @Query("select r from Region r where lower(r.name) like concat('%', lower(:q), '%') " +
            "or lower(r.state.name) like concat('%', lower(:q), '%') " +
            "or lower(r.state.country.name) like concat(lower(:q), '%')")
    Page<Region> q(@Param("q") String q, Pageable pageable);
}
