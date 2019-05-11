package app.timetables.api.schedule.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(types = Timetable.class)
public interface TimetableProjection {
    public Long getId();

    @Value("#{target.supportedCompany.name}")
    public String getSupportedCompany();

    public Date getValidFrom();

    public Date getValidUntil();
}
