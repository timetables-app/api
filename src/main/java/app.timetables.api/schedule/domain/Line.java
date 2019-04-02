package app.timetables.api.schedule.domain;

import java.util.Set;

public class Line {
    private String number;
    private VehicleType vehicleType;
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
