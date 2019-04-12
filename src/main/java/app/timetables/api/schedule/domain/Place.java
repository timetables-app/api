package app.timetables.api.schedule.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Place extends Obsoletable {
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PlaceType type;
    @Column(nullable = false)
    private Double lat;
    @Column(nullable = false)
    private Double lng;
    @ManyToOne(optional = false)
    private Locality locality;
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Set<Amenity> amenities;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String explanation;
    @ManyToOne
    private Place isVariantOf;
    @Column(nullable = false)
    private Integer capacity;

    public Place(PlaceType type, Double lat, Double lng, Locality locality, Set<Amenity> amenities, String name, String explanation, Place isVariantOf, Integer capacity) {
        this.type = type;
        this.lat = lat;
        this.lng = lng;
        this.locality = locality;
        this.amenities = amenities;
        this.name = name;
        this.explanation = explanation;
        this.isVariantOf = isVariantOf;
        this.capacity = capacity;
    }

    public PlaceType getType() {
        return type;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLng() {
        return lng;
    }

    public Locality getLocality() {
        return locality;
    }

    public Set<Amenity> getAmenities() {
        return amenities;
    }

    public String getName() {
        return name;
    }

    public String getExplanation() {
        return explanation;
    }

    public Place getIsVariantOf() {
        return isVariantOf;
    }

    public Integer getCapacity() {
        return capacity;
    }
}
