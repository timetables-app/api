package app.timetables.api.schedule.domain;

import app.timetables.api.community.domain.Company;

import java.util.Date;

public class Timetable {
    private Date validFrom;
    private Date validUntil;
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
