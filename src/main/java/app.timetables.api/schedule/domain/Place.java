package app.timetables.api.schedule.domain;

import java.util.Set;

public class Place implements Obsoletable {
    private PlaceType type;
    private Double lat;
    private Double lng;
    private Locality locality;
    private Set<Amenity> amenities;
    private String name;
    private String explanation;
    private Place isVariantOf;
    private Integer capacity;
    private Boolean isObsolete;

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

    public Boolean isObsolete() {
        return isObsolete;
    }

    public void setIsObsolete(Boolean obsolete) {
        isObsolete = obsolete;
    }
}
