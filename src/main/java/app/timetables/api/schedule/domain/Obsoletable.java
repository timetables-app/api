package app.timetables.api.schedule.domain;

public interface Obsoletable {
    Boolean isObsolete();

    void setIsObsolete(Boolean isObsolete);
}
