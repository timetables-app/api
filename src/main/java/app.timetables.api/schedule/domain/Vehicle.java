package app.timetables.api.schedule.domain;

import app.timetables.api.community.domain.Company;

import java.util.Set;

public class Vehicle {
    private VehicleType type;
    private Set<Amenity> amenities;
    private String make;
    private String model;
    private String number;
    private Integer numberOfSeats;
    private Integer standingRoomCapacity;
    private Company owningCompany;

    public Vehicle(VehicleType type, Set<Amenity> amenities, String make, String model, String number, Integer numberOfSeats, Integer standingRoomCapacity, Company owningCompany) {
        this.type = type;
        this.amenities = amenities;
        this.make = make;
        this.model = model;
        this.number = number;
        this.numberOfSeats = numberOfSeats;
        this.standingRoomCapacity = standingRoomCapacity;
        this.owningCompany = owningCompany;
    }

    public VehicleType getType() {
        return type;
    }

    public Set<Amenity> getAmenities() {
        return amenities;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getNumber() {
        return number;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public Integer getStandingRoomCapacity() {
        return standingRoomCapacity;
    }

    public Company getOwningCompany() {
        return owningCompany;
    }
}
