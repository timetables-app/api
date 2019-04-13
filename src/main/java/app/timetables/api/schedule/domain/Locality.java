package app.timetables.api.schedule.domain;

import javax.persistence.*;

@Entity
public class Locality extends Obsoletable {
    @ManyToOne(optional = false)
    @JoinColumn(updatable = false)
    private Region region;
    @Column(nullable = false, updatable = false)
    private String name;

    Locality() {
    }

    public Locality(Region region, String name) {
        this.region = region;
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public String getName() {
        return name;
    }
}
