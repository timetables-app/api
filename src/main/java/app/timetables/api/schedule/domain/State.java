package app.timetables.api.schedule.domain;

import javax.persistence.*;

@Entity
public class State extends Obsoletable {
    @ManyToOne(optional = false)
    @JoinColumn(updatable = false)
    private Country country;
    @Column(nullable = false, updatable = false)
    private String name;
    @Column(nullable = false, updatable = false)
    private String code;

    State() {
    }

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
