package app.timetables.api.community.controllers;

import app.timetables.api.community.domain.Company;
import app.timetables.api.community.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/companies")
public class CompanyController {

    private static final String DEFAULT_PAGE_SIZE = "20";

    private static final String DEFAULT_PAGE_NUMBER = "0";

    private static final String DEFAULT_SORT = "id,asc";

    @Autowired
    private CompanyRepository companyRepository;

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
        String[] sortData = sort.split(",");
        if (sortData.length != 2) {
            return ResponseEntity.of(Optional.empty());
        }

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(sortData[1]), sortData[0]);
        return ResponseEntity.of(Optional.of(companyRepository.findAll(pageable)));
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
