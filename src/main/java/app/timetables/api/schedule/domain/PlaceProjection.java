package app.timetables.api.schedule.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Place.class)
public interface PlaceProjection {
    public Long getId();

    @Value("#{target.locality.name}")
    public String getLocality();

    @Value("#{target.locality.region.name}")
    public String getRegion();

    @Value("#{target.locality.region.state.name}")
    public String getState();

    @Value("#{target.locality.region.state.country.name}")
    public String getCountry();

    public String getName();

    public Double getLat();

    public Double getLng();
}
