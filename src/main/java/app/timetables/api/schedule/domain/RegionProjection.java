package app.timetables.api.schedule.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Region.class)
public interface RegionProjection {
    @Value("#{target.state.name}")
    public String getState();

    @Value("#{target.state.country.name}")
    public String getCountry();

    public String getName();

    public String getCode();
}
