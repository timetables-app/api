package app.timetables.api.community.service;

import app.timetables.api.community.domain.Company;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

public interface CompanySearchInterface {

    public static final Integer DEFAULT_PAGE_SIZE = 20;

    public static final Integer DEFAULT_PAGE_NUMBER = 0;

    public static final String DEFAULT_SORT_COLUMN = "id";

    public static final String DEFAULT_SORT_DIRECTION = "asc";

    public void size(Integer size);

    public void page(Integer page);

    public void sort(String column, String direction);

    public void search(String query);

    public Page<Company> search();
}
