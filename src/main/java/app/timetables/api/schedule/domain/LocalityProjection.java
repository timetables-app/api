package app.timetables.api.schedule.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Locality.class)
public interface LocalityProjection {
    @Value("#{target.region.name}")
    public String getRegion();

    @Value("#{target.region.state.name}")
    public String getState();

    @Value("#{target.region.state.country.name}")
    public String getCountry();

    public String getName();
}
