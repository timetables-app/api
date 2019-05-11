package app.timetables.api.schedule.domain;

import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class CoursePart extends EntityBase {
    @ManyToOne(optional = false)
    @JoinColumn(updatable = false)
    @NonNull
    @Getter
    private Place source;

    @ManyToOne(optional = false)
    @JoinColumn(updatable = false)
    @NonNull
    @Getter
    private Place destination;

    @Column(nullable = false, updatable = false)
    @NonNull
    @Getter
    private LocalTime sourceTime;

    @Column(nullable = false, updatable = false)
    @NonNull
    @Getter
    private LocalTime destinationTime;

    @Column(nullable = false, updatable = false)
    @NonNull
    @Getter
    private Boolean destinationOnDemand;

    @ManyToOne(optional = false)
    @JoinColumn(updatable = false)
    @NonNull
    @Getter
    private Course course;
}
