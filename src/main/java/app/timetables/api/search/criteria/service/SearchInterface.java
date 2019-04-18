package app.timetables.api.search.criteria.service;

import org.springframework.data.domain.Page;

public interface SearchInterface<T> {

    Integer DEFAULT_PAGE_SIZE = 20;

    Integer DEFAULT_PAGE_NUMBER = 0;

    String DEFAULT_SORT_COLUMN = "id";

    String DEFAULT_SORT_DIRECTION = "asc";

    SearchInterface size(Integer size);

    SearchInterface page(Integer page);

    SearchInterface sort(String order);

    SearchInterface sort(
        String column,
        String direction
    );

    SearchInterface query(String query);

    Page<T> search();
}
