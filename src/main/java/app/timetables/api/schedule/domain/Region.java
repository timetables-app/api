package app.timetables.api.schedule.domain;

import javax.persistence.*;

@Entity
public class Region implements Obsoletable {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(optional = false)
    private State state;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private Boolean isObsolete;

    public Region(State state, String name, String code) {
        this.state = state;
        this.name = name;
        this.code = code;
        this.isObsolete = false;
    }

    public State getState() {
        return state;
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
