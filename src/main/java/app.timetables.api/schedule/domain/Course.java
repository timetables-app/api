package app.timetables.api.schedule.domain;

public class Course {
    private Timetable timetable;
    private Line line;
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
