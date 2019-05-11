package app.timetables.api.schedule.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
abstract class Obsoletable extends EntityBase {
    @Column(nullable = false)
    @Getter
    @Setter
    private Boolean obsolete = false;
}
