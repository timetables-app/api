package app.timetables.api.community.repository;

import app.timetables.api.MainApp;
import app.timetables.api.community.domain.Company;
import app.timetables.api.community.service.CompanySearchBuilder;
import app.timetables.api.community.service.CompanySearchBuilderInterface;
import app.timetables.api.community.service.CompanySearchInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@AutoConfigureDataJpa
@SpringBootTest(classes = MainApp.class)
public class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanySearchBuilderInterface companySearchBuilder;

    @Test
    public void testSearchingCompanyByCustomField() {
        CompanySearchInterface companySearch = companySearchBuilder
                .page(0)
                .size(20)
                .search("Pierwsza firma - test")
                .build();

        assertEquals(1, companySearch.search().getTotalElements());
    }
}