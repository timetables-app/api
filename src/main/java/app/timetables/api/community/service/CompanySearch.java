package app.timetables.api.community.service;

import app.timetables.api.community.domain.Company;
import app.timetables.api.community.repository.CompanyRepository;
import app.timetables.api.community.repository.CompanySpecification;
import app.timetables.api.community.repository.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CompanySearch implements CompanySearchInterface {

    private Integer size = DEFAULT_PAGE_SIZE;

    private Integer page = DEFAULT_PAGE_NUMBER;

    private String sortColumn = DEFAULT_SORT_COLUMN;

    private String sortDirection = DEFAULT_SORT_DIRECTION;

    private String query;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void size(Integer size) {
        this.size = size;
    }

    @Override
    public void page(Integer page) {
        this.page = page;
    }

    @Override
    public void sort(String column, String direction) {
        this.sortColumn = column;
        this.sortDirection = direction;
    }

    @Override
    public void search(String query) {
        this.query = query;
    }

    @Override
    public Page<Company> search() {
        if (query.isEmpty()) {
            return companyRepository.findAll(createPageRequest());
        }

        return companyRepository.findAll(createSpecification(), createPageRequest());
    }

    private PageRequest createPageRequest() {
        return PageRequest.of(page, size, Sort.Direction.fromString(sortDirection), sortColumn);
    }

    private Specification<Company> createSpecification() {
        CompanySpecification companyNameSpecification = new CompanySpecification(new SearchCriteria("name", "like", query));
        CompanySpecification companyPhoneSpecification = new CompanySpecification(new SearchCriteria("phone", "like", query));

        return Specification.where(companyNameSpecification).or(companyPhoneSpecification);
    }
}
