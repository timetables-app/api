package app.timetables.api.community.service;

import app.timetables.api.community.domain.Company;
import app.timetables.api.community.repository.CompanyRepository;
import app.timetables.api.search.criteria.SearchCriteria;
import app.timetables.api.search.criteria.repository.SearchableRepository;
import app.timetables.api.search.criteria.service.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CompanySearch extends Search<Company, Long> {

    private CompanyRepository companyRepository;

    @Autowired
    public CompanySearch(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    protected Specification<Company> createSpecification() {
        CompanySearchSpecification companyNameSpecification = new CompanySearchSpecification(
            new SearchCriteria("name", "like", query)
        );
        CompanySearchSpecification companyPhoneSpecification = new CompanySearchSpecification(
            new SearchCriteria("phone", "like", query)
        );

        return Specification.where(companyNameSpecification).or(companyPhoneSpecification);
    }

    @Override
    protected SearchableRepository<Company, Long> getRepository() {
        return companyRepository;
    }
}
