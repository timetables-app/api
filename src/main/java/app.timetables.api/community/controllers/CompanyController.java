package app.timetables.api.community.controllers;

import app.timetables.api.community.domain.Company;
import app.timetables.api.community.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Company> getCompany(@PathVariable Long id) {
        return ResponseEntity.of(companyRepository.findById(id));
    }

    @GetMapping(produces = "application/json")
    public Iterable<Company> getCompanies(@RequestParam(defaultValue = "10") Integer size, @RequestParam(defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of(page, size);
        return companyRepository.findAll(pageable);
    }

    @PostMapping(value = "/approve/company/{id}", produces = "application/json")
    public ResponseEntity<Company> approveCompany(@PathVariable Integer id) {
        Optional<Company> optionalCompany = companyRepository.findById(Long.valueOf(id));
        if (optionalCompany.isPresent()) {
            optionalCompany.get().setApproved(true);
            companyRepository.save(optionalCompany.get());
        }

        return ResponseEntity.of(optionalCompany);
    }

    @PostMapping(value = "/block/company/{id}", produces = "application/json")
    public ResponseEntity<Company> blockCompany(@PathVariable Integer id) {
        Optional<Company> optionalCompany = companyRepository.findById(Long.valueOf(id));
        if (optionalCompany.isPresent()) {
            optionalCompany.get().setApproved(false);
            companyRepository.save(optionalCompany.get());
        }

        return ResponseEntity.of(optionalCompany);
    }

}
