package app.timetables.api.schedule.domain;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
abstract class EntityBase implements Serializable {
    @Id
    @GeneratedValue
    @Getter
    private Long id;
}
