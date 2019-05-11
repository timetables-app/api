package app.timetables.api.schedule.service;

import app.timetables.api.schedule.domain.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin
interface CountryRepository extends PagingAndSortingRepository<Country, Long> {

    @RestResource(exported = false)
    @Override
    void delete(Country entity);

    @Query("select c from Country c where lower(c.name) like concat(lower(:q), '%')" +
            "or lower(c.iso) like concat(lower(:q), '%')" +
            "or lower(c.iso3) like concat(lower(:q), '%')")
    Page<Country> q(@Param("q") String q, Pageable pageable);
}
