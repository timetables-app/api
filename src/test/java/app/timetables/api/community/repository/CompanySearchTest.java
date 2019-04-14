package app.timetables.api.community.repository;

import app.timetables.api.MainApp;
import app.timetables.api.community.service.CompanySearch;
import app.timetables.api.community.service.CompanySearchInterface;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@AutoConfigureDataJpa
@SpringBootTest(classes = MainApp.class)
public class CompanySearchTest {

    @Autowired
    private CompanyRepository companyRepository;

    private CompanySearchInterface companySearch;

    @Before
    public void setUp() throws Exception {
        companySearch = new CompanySearch(companyRepository);
    }

    @Test
    public void testSearchingCompanyByCustomField() {
        companySearch.page(0)
                .size(20)
                .query("Pierwsza firma - test");

        assertEquals(1, companySearch.search().getTotalElements());
    }

    @Test
    public void testSearchingCompanyWithQuery() {
        companySearch.page(0)
                .size(20)
                .query("test");

        assertEquals(5, companySearch.search().getTotalElements());
    }

    @Test
    public void testSearchingCompanyWithoutQuery() {
        assertEquals(10, companySearch.search().getTotalElements());
    }
}