package app.timetables.api.community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanySearchBuilder implements CompanySearchBuilderInterface {

    @Autowired
    private CompanySearchInterface companySearch;

    @Override
    public CompanySearchBuilderInterface size(Integer size) {
        companySearch.size(size);

        return this;
    }

    @Override
    public CompanySearchBuilderInterface page(Integer page) {
        companySearch.page(page);

        return this;
    }

    @Override
    public CompanySearchBuilderInterface sort(String column, String direction) {
        companySearch.sort(column, direction);

        return this;
    }

    @Override
    public CompanySearchBuilderInterface search(String query) {
        companySearch.search(query);

        return this;
    }

    @Override
    public CompanySearchInterface build() {
        return companySearch;
    }
}
