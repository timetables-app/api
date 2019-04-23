package app.timetables.api.schedule.service;

import app.timetables.api.schedule.domain.State;
import app.timetables.api.schedule.domain.StateProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(excerptProjection = StateProjection.class)
@CrossOrigin
interface StateRepository extends PagingAndSortingRepository<State, Long> {


    @Query("select s from State s where lower(s.name) like concat('%',lower(:q), '%')" +
            "or lower(s.country.name) like concat(lower(:q), '%')")
    Page<State> q(@Param("q") String q, Pageable pageable);
}
