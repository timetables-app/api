package app.timetables.api.schedule.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = State.class)
public interface StateProjection {
    @Value("#{target.country.name}")
    public String getCountry();

    public String getName();

    public String getCode();
}
