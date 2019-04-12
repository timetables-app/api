package app.timetables.api.schedule.domain;

import javax.persistence.*;

@Entity
public class Region extends Obsoletable {
    @ManyToOne(optional = false)
    private State state;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String code;

    public Region(State state, String name, String code) {
        this.state = state;
        this.name = name;
        this.code = code;
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
}
