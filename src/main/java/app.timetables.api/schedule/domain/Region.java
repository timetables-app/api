package app.timetables.api.schedule.domain;

public class Region implements Obsoletable {
    private State state;
    private String name;
    private String code;
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
