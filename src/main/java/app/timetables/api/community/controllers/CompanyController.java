package app.timetables.api.community.controllers;

import app.timetables.api.community.domain.Company;
import app.timetables.api.community.repository.CompanyRepository;
import app.timetables.api.community.service.CompanySearch;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/companies")
public class CompanyController {

    private static final String DEFAULT_PAGE_SIZE = "20";

    private static final String DEFAULT_PAGE_NUMBER = "0";

    private static final String DEFAULT_SORT = "id,asc";

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanySearch companySearch;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Company> getCompany(@PathVariable Long id) {
        return ResponseEntity.of(companyRepository.findById(id));
    }

    @GetMapping(produces = "application/json")
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

    @GetMapping(value = "/search/q", produces = "application/json")
    public ResponseEntity<Iterable<Company>> getCompanies(
        @RequestParam(required = true, name = "q") String query,
        @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) Integer size,
        @RequestParam(defaultValue = DEFAULT_PAGE_NUMBER) Integer page,
        @RequestParam(defaultValue = DEFAULT_SORT) String sort
    ) {
        companySearch.size(size)
            .page(page)
            .sort(sort)
            .query(query);

        return ResponseEntity.of(Optional.of(companySearch.search()));
    }

    @PostMapping(value = "/approve/{id}", produces = "application/json")
    public ResponseEntity<Company> approveCompany(@PathVariable Integer id) {
        Optional<Company> optionalCompany = companyRepository.findById(Long.valueOf(id));
        if (optionalCompany.isPresent()) {
            optionalCompany.get().setApproved(true);
            companyRepository.save(optionalCompany.get());
        }

        return ResponseEntity.of(optionalCompany);
    }

    @PostMapping(value = "/block/{id}", produces = "application/json")
    public ResponseEntity<Company> blockCompany(@PathVariable Integer id) {
        Optional<Company> optionalCompany = companyRepository.findById(Long.valueOf(id));
        if (optionalCompany.isPresent()) {
            optionalCompany.get().setApproved(false);
            companyRepository.save(optionalCompany.get());
        }

        return ResponseEntity.of(optionalCompany);
    }

}
