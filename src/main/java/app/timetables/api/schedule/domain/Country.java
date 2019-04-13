package app.timetables.api.schedule.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Country extends Obsoletable {
    @Column(nullable = false, updatable = false)
    private String iso;

    @Column(nullable = false, updatable = false)
    private String name;

    @Column(nullable = false, updatable = false)
    private String iso3;


    Country() {
    }

    public Country(String name, String iso, String iso3) {
        this.name = name;
        this.iso = iso;
        this.iso3 = iso3;
    }

    public String getName() {
        return name;
    }

    public String getIso() {
        return iso;
    }

    public String getIso3() {
        return iso3;
    }
}
