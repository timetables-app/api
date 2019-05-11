package app.timetables.api.schedule.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalTime;
import java.util.Date;

@Projection(types = CoursePart.class)
public interface CoursePartProjection {
    @Value("#{target.source.name} #{target.source.locality.name}")
    public String getSource();

    @Value("#{target.destination.name} #{target.destination.locality.name}")
    public String getDestination();

    public LocalTime getSourceTime();

    public LocalTime getDestinationTime();

    @Value("#{target.course.line.number}")
    public String getLineNumber();

    @Value("#{target.course.line.vehicleType}")
    public VehicleType getVehicleType();

    @Value("#{target.course.timetable.validFrom}")
    public Date getValidFrom();

    @Value("#{target.course.timetable.validUntil}")
    public Date getValidUntil();

    @Value("#{target.course.timetable.supportedCompany.name}")
    public String getSupportedCompany();
}
