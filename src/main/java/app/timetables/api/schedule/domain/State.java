package app.timetables.api.schedule.domain;

import javax.persistence.*;

@Entity
public class State implements Obsoletable {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(optional = false)
    private Country country;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private Boolean isObsolete;

    public State(Country country, String name, String code) {
        this.country = country;
        this.name = name;
        this.code = code;
        this.isObsolete = false;
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

    public Boolean isObsolete() {
        return isObsolete;
    }

    public void setIsObsolete(Boolean obsolete) {
        isObsolete = obsolete;
    }
}
