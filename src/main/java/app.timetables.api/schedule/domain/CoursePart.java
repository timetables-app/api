package app.timetables.api.schedule.domain;

import java.util.Date;

public class CoursePart {
    private Place source;
    private Place destination;
    private Date sourceTime;
    private Date destinationTime;
    private Boolean isDestinationOnDemand;
    private Course course;

    public CoursePart(Place source, Place destination, Date sourceTime, Date destinationTime, Boolean isDestinationOnDemand, Course course) {
        this.source = source;
        this.destination = destination;
        this.sourceTime = sourceTime;
        this.destinationTime = destinationTime;
        this.isDestinationOnDemand = isDestinationOnDemand;
        this.course = course;
    }

    public Place getSource() {
        return source;
    }

    public Place getDestination() {
        return destination;
    }

    public Date getSourceTime() {
        return sourceTime;
    }

    public Date getDestinationTime() {
        return destinationTime;
    }

    public Boolean isDestinationOnDemand() {
        return isDestinationOnDemand;
    }

    public Course getCourse() {
        return course;
    }
}
