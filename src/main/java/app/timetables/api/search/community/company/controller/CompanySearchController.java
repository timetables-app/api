package app.timetables.api.search.community.company.controller;

import app.timetables.api.community.domain.Company;
import app.timetables.api.search.community.company.CompanySearchQuery;
import app.timetables.api.search.community.company.service.CompanySearch;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CompanySearchController {

    private static final String DEFAULT_PAGE_SIZE = "20";

    private static final String DEFAULT_PAGE_NUMBER = "0";

    private static final String DEFAULT_SORT = "id,asc";

    @Autowired
    private CompanySearch companySearch;

    @GetMapping(value = "/companies/{id}")
    public ResponseEntity<Company> getById(@PathVariable Long id) {
        return ResponseEntity.of(companySearch.getById(id));
    }

    @GetMapping(value = "/companies", produces = "application/json")
    public ResponseEntity<Iterable<Company>> getCompanies(
        @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) Integer size,
        @RequestParam(defaultValue = DEFAULT_PAGE_NUMBER) Integer page,
        @RequestParam(defaultValue = DEFAULT_SORT) String sort
    ) {
        companySearch.size(size)
            .page(page)
            .sort(sort);

        return ResponseEntity.of(Optional.of(companySearch.search()));
    }

    @GetMapping(value = "/companies/search/q", produces = "application/json")
    public ResponseEntity<Iterable<Company>> search(
        @RequestParam(defaultValue = "", name = "q") String query,
        @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) Integer size,
        @RequestParam(defaultValue = DEFAULT_PAGE_NUMBER) Integer page,
        @RequestParam(defaultValue = DEFAULT_SORT) String sort
    ) {
        companySearch.size(size)
            .page(page)
            .sort(sort)
            .specificationFor(new CompanySearchQuery(query, query));

        return ResponseEntity.of(Optional.of(companySearch.search()));
    }

}
