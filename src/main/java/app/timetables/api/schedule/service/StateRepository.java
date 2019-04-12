package app.timetables.api.schedule.service;

import app.timetables.api.schedule.domain.State;
import app.timetables.api.schedule.domain.StateProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(excerptProjection = StateProjection.class)
@CrossOrigin
interface StateRepository extends PagingAndSortingRepository<State, Long> {
}
