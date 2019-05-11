package app.timetables.api.schedule.domain;

import java.util.Objects;
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
    private String explanation = "";

    @ManyToOne
    @JoinColumn(updatable = false)
    @Getter
    private Place variantOf;

    @Column(nullable = false, updatable = false)
    @Getter
    @NonNull
    private Integer capacity;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Place place = (Place) o;
        return getId().equals(place.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
