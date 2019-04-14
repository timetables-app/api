package app.timetables.api.community.service;

import app.timetables.api.community.domain.Company;
import org.springframework.data.domain.Page;

public interface CompanySearchInterface {

    public static final Integer DEFAULT_PAGE_SIZE = 20;

    public static final Integer DEFAULT_PAGE_NUMBER = 0;

    public static final String DEFAULT_SORT_COLUMN = "id";

    public static final String DEFAULT_SORT_DIRECTION = "asc";

    public CompanySearchInterface size(Integer size);

    public CompanySearchInterface page(Integer page);

    public CompanySearchInterface sort(String order);

    public CompanySearchInterface sort(String column, String direction);

    public CompanySearchInterface query(String query);

    public Page<Company> search();
}
