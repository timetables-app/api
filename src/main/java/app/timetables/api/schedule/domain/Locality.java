package app.timetables.api.schedule.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class Locality extends Obsoletable {
    @ManyToOne(optional = false)
    @JoinColumn(updatable = false)
    @NonNull
    @Getter
    private Region region;

    @Column(nullable = false, updatable = false)
    @NonNull
    @Getter
    private String name;
}
