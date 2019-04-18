package app.timetables.api.schedule.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Place extends Obsoletable {
    @Column(nullable = false, updatable = false)
    @Getter
    @NonNull
    private Double lat;

    @Column(nullable = false, updatable = false)
    @Getter
    @NonNull
    private Double lng;

    @ManyToOne(optional = false)
    @JoinColumn(updatable = false)
    @Getter
    @NonNull
    private Locality locality;

    @Column(nullable = false, updatable = false)
    @Getter
    @NonNull
    private String name;

    @Column(nullable = false, updatable = false)
    @Getter
    @NonNull
    private String explanation;

    @ManyToOne
    @JoinColumn(updatable = false)
    @Getter
    private Place variantOf;

    @Column(nullable = false, updatable = false)
    @Getter
    @NonNull
    private Integer capacity;
}
