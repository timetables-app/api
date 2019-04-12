package app.timetables.api.schedule.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
abstract class Obsoletable extends EntityBase {
    @Column(nullable = false)
    private Boolean isObsolete = false;

    public Boolean getObsolete() {
        return isObsolete;
    }

    public void setObsolete(Boolean obsolete) {
        isObsolete = obsolete;
    }
}
