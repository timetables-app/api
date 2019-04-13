package app.timetables.api.schedule.service;

import app.timetables.api.schedule.domain.Locality;
import app.timetables.api.schedule.domain.LocalityProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(excerptProjection = LocalityProjection.class)
@CrossOrigin
interface LocalityRepository extends PagingAndSortingRepository<Locality, Long> {
}
