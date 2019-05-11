package app.timetables.api.schedule.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(types = Course.class)
public interface CourseProjection {
    public Long getId();

    @Value("#{target.timetable.supportedCompany.name}")
    public String getSupportedCompany();

    @Value("#{target.line.vehicleType}")
    public VehicleType getVehicleType();

    @Value("#{target.line.number}")
    public String getLineNumber();
}
