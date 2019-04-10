package app.timetables.api.schedule.service;

import app.timetables.api.schedule.domain.Country;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface CountryRepository extends PagingAndSortingRepository<Country, Long> {
}
