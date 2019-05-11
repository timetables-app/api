package app.timetables.api.schedule.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class Course extends EntityBase {
    @ManyToOne(optional = false)
    @JoinColumn(updatable = false)
    @NonNull
    @Getter
    private Timetable timetable;

    @ManyToOne(optional = false)
    @JoinColumn(updatable = false)
    @NonNull
    @Getter
    private Line line;
}
