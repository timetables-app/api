package app.timetables.api.schedule.domain;

import app.timetables.api.community.domain.Company;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class Timetable extends EntityBase {
    @Column(nullable = false, updatable = false)
    @NonNull
    @Getter
    private Date validFrom;

    @Column(nullable = false, updatable = false)
    @NonNull
    @Getter
    private Date validUntil;

    @ManyToOne(optional = false)
    @JoinColumn(updatable = false)
    @NonNull
    @Getter
    private Company supportedCompany;
}
