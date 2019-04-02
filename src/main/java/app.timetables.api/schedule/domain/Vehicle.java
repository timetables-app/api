package app.timetables.api.schedule.domain;

import app.timetables.api.community.domain.Company;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VehicleType type;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<Amenity> amenities;
    @Column(nullable = false)
    private String make;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private Integer numberOfSeats;
    @Column(nullable = false)
    private Integer standingRoomCapacity;
    @ManyToOne(optional = false)
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
