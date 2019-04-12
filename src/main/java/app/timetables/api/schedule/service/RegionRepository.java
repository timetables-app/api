package app.timetables.api.schedule.service;

import app.timetables.api.schedule.domain.Region;
import app.timetables.api.schedule.domain.RegionProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(excerptProjection = RegionProjection.class)
@CrossOrigin
interface RegionRepository extends PagingAndSortingRepository<Region, Long> {
}
