package app.timetables.api.schedule.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Country implements Obsoletable {
    @Id
    private String iso;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String iso3;
    @Column(nullable = false)
    private Boolean isObsolete;

    public Country(String name, String iso, String iso3) {
        this.name = name;
        this.iso = iso;
        this.iso3 = iso3;
        this.isObsolete = false;
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

    public Boolean isObsolete() {
        return isObsolete;
    }

    public void setIsObsolete(Boolean isObsolete) {
        this.isObsolete = isObsolete;
    }
}
