package app.timetables.api.schedule.domain;

import javax.persistence.*;

@Entity
public class State extends Obsoletable {
    @ManyToOne(optional = false)
    private Country country;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String code;

    public State(Country country, String name, String code) {
        this.country = country;
        this.name = name;
        this.code = code;
    }

    public Country getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
