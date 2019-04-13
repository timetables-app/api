package app.timetables.api.schedule.service;

import app.timetables.api.schedule.domain.Place;
import app.timetables.api.schedule.domain.PlaceProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(excerptProjection = PlaceProjection.class)
@CrossOrigin
interface PlaceRepository extends PagingAndSortingRepository<Place, Long> {

    @RestResource(exported = false)
    @Override
    void delete(Place entity);

    @Query("select p from Place p where lower(p.name) like concat(lower(:q), '%')")
    Page<Place> q(@Param("q") String q, Pageable pageable);
}
