package app.timetables.api.search.criteria.service;

import app.timetables.api.search.criteria.repository.SearchableRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public abstract class Search<T, ID> implements SearchInterface<T> {

    private Integer size = DEFAULT_PAGE_SIZE;

    private Integer page = DEFAULT_PAGE_NUMBER;

    private String sortColumn = DEFAULT_SORT_COLUMN;

    private String sortDirection = DEFAULT_SORT_DIRECTION;

    protected String query;

    protected abstract Specification<T> createSpecification();

    protected abstract SearchableRepository<T, ID> getRepository();

    @Override
    public SearchInterface size(Integer size) {
        this.size = size;

        return this;
    }

    @Override
    public SearchInterface page(Integer page) {
        this.page = page;

        return this;
    }

    @Override
    public SearchInterface sort(String order) {
        String[] sortData = order.split(",");
        if (sortData.length == 2) {
            sort(sortData[0], sortData[1]);
        }

        return this;
    }

    @Override
    public SearchInterface sort(String column, String direction) {
        this.sortColumn = column;
        this.sortDirection = direction;

        return this;
    }

    @Override
    public SearchInterface query(String query) {
        this.query = query;

        return this;
    }

    @Override
    public Page<T> search() {
        if (query == null || query.isEmpty()) {
            return getRepository().findAll(createPageRequest());
        }

        return getRepository().findAll(createSpecification(), createPageRequest());
    }

    private PageRequest createPageRequest() {
        return PageRequest.of(page, size, Sort.Direction.fromString(sortDirection), sortColumn);
    }
}
