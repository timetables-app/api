package app.timetables.api.schedule.domain;

import javax.persistence.*;

@Entity
public class Locality implements Obsoletable {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(optional = false)
    private Region region;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Boolean isObsolete;

    public Locality(Region region, String name) {
        this.region = region;
        this.name = name;
        this.isObsolete = false;
    }

    public Region getRegion() {
        return region;
    }

    public String getName() {
        return name;
    }

    public Boolean isObsolete() {
        return isObsolete;
    }

    public void setIsObsolete(Boolean obsolete) {
        isObsolete = obsolete;
    }
}
