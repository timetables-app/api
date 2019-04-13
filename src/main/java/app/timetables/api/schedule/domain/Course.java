package app.timetables.api.schedule.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Course extends EntityBase {
    @ManyToOne(optional = false)
    private Timetable timetable;
    @ManyToOne(optional = false)
    private Line line;
    @ManyToOne(optional = false)
    private Vehicle supportedVehicle;

    public Course(Timetable timetable, Line line, Vehicle supportedVehicle) {
        this.timetable = timetable;
        this.line = line;
        this.supportedVehicle = supportedVehicle;
    }

    public Timetable getTimetable() {
        return timetable;
    }

    public Line getLine() {
        return line;
    }

    public Vehicle getSupportedVehicle() {
        return supportedVehicle;
    }
}
