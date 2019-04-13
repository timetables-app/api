package app.timetables.api.community.service;

import org.springframework.context.annotation.Bean;

public interface CompanySearchBuilderInterface {

    public CompanySearchBuilderInterface size(Integer size);

    public CompanySearchBuilderInterface page(Integer page);

    public CompanySearchBuilderInterface sort(String column, String direction);

    public CompanySearchBuilderInterface search(String query);

    public CompanySearchInterface build();
}
