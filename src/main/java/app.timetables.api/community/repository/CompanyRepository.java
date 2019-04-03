package app.timetables.api.community.repository;

import app.timetables.api.community.domain.Company;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {
}
