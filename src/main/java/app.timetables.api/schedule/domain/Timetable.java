package app.timetables.api.schedule.domain;

import app.timetables.api.community.domain.Company;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Timetable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Date validFrom;
    @Column(nullable = false)
    private Date validUntil;
    @ManyToOne(optional = false)
    private Company supportedCompany;

    public Timetable(Date validFrom, Date validUntil, Company supportedCompany) {
        this.validFrom = validFrom;
        this.validUntil = validUntil;
        this.supportedCompany = supportedCompany;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public Company getSupportedCompany() {
        return supportedCompany;
    }
}
