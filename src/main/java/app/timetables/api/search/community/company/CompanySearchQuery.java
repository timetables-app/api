package app.timetables.api.search.community.company;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CompanySearchQuery {

    private final String name;

    private final String phone;

}
