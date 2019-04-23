package app.timetables.api.search.criteria;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SearchCriteria {
    private final String key;
    private final String operation;
    private final Object value;
}
