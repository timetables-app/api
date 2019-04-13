package app.timetables.api.schedule.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Course extends EntityBase {
    @ManyToOne(optional = false)
    private Timetable timetable;
    @ManyToOne(optional = false)
    private Line line;

    public Course(Timetable timetable, Line line) {
        this.timetable = timetable;
        this.line = line;
    }

    public Timetable getTimetable() {
        return timetable;
    }

    public Line getLine() {
        return line;
    }
}
