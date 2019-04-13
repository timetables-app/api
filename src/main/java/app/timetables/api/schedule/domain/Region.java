package app.timetables.api.schedule.domain;

import javax.persistence.*;

@Entity
public class Region extends Obsoletable {
    @ManyToOne(optional = false)
    @JoinColumn(updatable = false)
    private State state;
    @Column(nullable = false, updatable = false)
    private String name;
    @Column(nullable = false, updatable = false)
    private String code;

    Region() {
    }

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
