package app.timetables.api.schedule.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class State extends Obsoletable {
    @ManyToOne(optional = false)
    @JoinColumn(updatable = false)
    @NonNull
    @Getter
    private Country country;

    @Column(nullable = false, updatable = false)
    @NonNull
    @Getter
    private String name;

    @Column(nullable = false, updatable = false)
    @NonNull
    @Getter
    private String code;
}
