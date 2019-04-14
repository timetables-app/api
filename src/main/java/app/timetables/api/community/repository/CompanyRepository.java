package app.timetables.api.community.repository;

import app.timetables.api.community.domain.Company;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long>, JpaSpecificationExecutor<Company> {
}
