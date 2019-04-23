package app.timetables.api.search.schedule.place;

import lombok.Data;

@Data
public class PlaceSearchQuery {

    private String countryIsoCode;

    private String stateCode;

    private String regionCode;

    private String localityName;

    private String name;

}
