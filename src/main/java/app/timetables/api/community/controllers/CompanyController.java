package app.timetables.api.community.controllers;

import app.timetables.api.community.domain.Company;
import app.timetables.api.community.repository.CompanyRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

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
