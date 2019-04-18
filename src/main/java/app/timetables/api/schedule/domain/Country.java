package app.timetables.api.schedule.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class Country extends Obsoletable {
    @Column(nullable = false, updatable = false)
    @Getter
    @NonNull
    private String iso;

    @Column(nullable = false, updatable = false)
    @Getter
    @NonNull
    private String name;

    @Column(nullable = false, updatable = false)
    @Getter
    @NonNull
    private String iso3;
}
