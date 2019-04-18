package app.timetables.api.community.repository;

import app.timetables.api.community.domain.Company;
import app.timetables.api.search.criteria.repository.SearchableRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends SearchableRepository<Company, Long> {

}
