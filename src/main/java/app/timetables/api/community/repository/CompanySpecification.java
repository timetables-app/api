package app.timetables.api.community.repository;

import app.timetables.api.community.domain.Company;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CompanySpecification implements Specification<Company> {

    private SearchCriteria criteria;

    public CompanySpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<Company> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        return builder.like(builder.lower(root.get(criteria.getKey())), builder.lower(builder.literal("%" + criteria.getValue() + "%")));
    }
}
