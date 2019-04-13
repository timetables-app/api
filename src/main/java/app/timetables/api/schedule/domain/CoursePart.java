package app.timetables.api.schedule.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class CoursePart extends EntityBase {
    @ManyToOne(optional = false)
    private Place source;
    @ManyToOne(optional = false)
    private Place destination;
    @Column(nullable = false)
    private Date sourceTime;
    @Column(nullable = false)
    private Date destinationTime;
    @Column(nullable = false)
    private Boolean isDestinationOnDemand;
    @ManyToOne(optional = false)
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
