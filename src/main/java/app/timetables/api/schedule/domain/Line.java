package app.timetables.api.schedule.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Line extends EntityBase {
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<Amenity> guaranteedAmenities;

    public Line(String number, VehicleType vehicleType, Set<Amenity> guaranteedAmenities) {
        this.number = number;
        this.vehicleType = vehicleType;
        this.guaranteedAmenities = guaranteedAmenities;
    }

    public String getNumber() {
        return number;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Set<Amenity> getGuaranteedAmenities() {
        return guaranteedAmenities;
    }
}
