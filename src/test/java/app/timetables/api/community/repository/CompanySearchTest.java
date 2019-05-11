package app.timetables.api.community.repository;

import static org.junit.Assert.*;

import app.timetables.api.MainApp;
import app.timetables.api.search.community.company.CompanySearchQuery;
import app.timetables.api.search.community.company.service.CompanySearch;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@AutoConfigureDataJpa
@SpringBootTest(classes = MainApp.class)
public class CompanySearchTest {

    @Autowired
    private CompanyRepository companyRepository;

    private CompanySearch companySearch;

    @Before
    public void setUp() throws Exception {
        companySearch = new CompanySearch(companyRepository);
    }

    @Test
    public void testSearchingCompanyByCustomField() {
        String query = "Pierwsza firma - test";
        CompanySearchQuery companySearchQuery = new CompanySearchQuery(query, query);

        companySearch.page(0)
            .size(20)
            .specificationFor(companySearchQuery);

        assertEquals(1, companySearch.search().getTotalElements());
    }

    @Test
    public void testSearchingCompanyWithQuery() {
        String query = "test";
        CompanySearchQuery companySearchQuery = new CompanySearchQuery(query, query);

        companySearch.page(0)
            .size(20)
            .specificationFor(companySearchQuery);

        assertEquals(5, companySearch.search().getTotalElements());
    }

    @Test
    public void testSearchingCompanyWithoutQuery() {
        assertEquals(10, companySearch.search().getTotalElements());
    }
}