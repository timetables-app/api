package app.timetables.api.search.community.company.service;

import app.timetables.api.community.domain.Company;
import app.timetables.api.community.repository.CompanyRepository;
import app.timetables.api.search.community.company.CompanySearchQuery;
import app.timetables.api.search.criteria.SearchCriteria;
import app.timetables.api.search.criteria.service.Search;
import app.timetables.api.search.criteria.service.SearchInterface;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanySearch extends Search<Company, Long> {

    private Map<String, Specification<Company>> specifications = new HashMap<>();

    private CompanyRepository companyRepository;

    @Autowired
    public CompanySearch(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public SearchInterface specificationFor(Object searchQuery) {
        CompanySearchQuery companySearchQuery = (CompanySearchQuery) searchQuery;

        if (!companySearchQuery.getName().isEmpty()) {
            specifications.put(
                "name",
                new CompanySearchSpecification(
                    new SearchCriteria("name", "like", companySearchQuery.getName()))
            );
        }

        if (!companySearchQuery.getPhone().isEmpty()) {
            specifications.put(
                "phone",
                new CompanySearchSpecification(
                    new SearchCriteria("phone", "like", companySearchQuery.getPhone()))
            );
        }

        buildSpecification();

        return this;
    }

    private void buildSpecification() {
        specification = Specification.where(specifications.get("name"))
            .or(specifications.get("phone"));
    }

    @Override
    protected PagingAndSortingRepository<Company, Long> getRepository() {
        return companyRepository;
    }

    @Override
    protected JpaSpecificationExecutor<Company> getSpecificationRepository() {
        return companyRepository;
    }
}
