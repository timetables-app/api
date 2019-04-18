package app.timetables.api.schedule.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class Line extends EntityBase {
    @Column(nullable = false, updatable = false)
    @NonNull
    @Getter
    private String number;

    @Column(nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    @NonNull
    @Getter
    private VehicleType vehicleType;
}
