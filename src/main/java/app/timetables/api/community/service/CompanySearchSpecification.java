package app.timetables.api.community.service;

import app.timetables.api.community.domain.Company;
import app.timetables.api.search.criteria.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CompanySearchSpecification implements Specification<Company> {

    private SearchCriteria criteria;

    public CompanySearchSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(
        Root<Company> root,
        CriteriaQuery<?> query,
        CriteriaBuilder builder
    ) {
        return builder.like(
            builder.lower(root.get(criteria.getKey())),
            builder.lower(builder.literal("%" + criteria.getValue() + "%"))
        );
    }
}
