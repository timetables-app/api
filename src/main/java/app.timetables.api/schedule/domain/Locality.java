package app.timetables.api.schedule.domain;

public class Locality implements Obsoletable {
    private Region region;
    private String name;
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
