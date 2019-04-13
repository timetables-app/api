package app.timetables.api.schedule.domain;

import javax.persistence.*;

@Entity
public class Place extends Obsoletable {
    @Column(nullable = false)
    private Double lat;
    @Column(nullable = false)
    private Double lng;
    @ManyToOne(optional = false)
    private Locality locality;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String explanation;
    @ManyToOne
    private Place isVariantOf;
    @Column(nullable = false)
    private Integer capacity;

    public Place(Double lat, Double lng, Locality locality, String name, String explanation, Place isVariantOf, Integer capacity) {
        this.lat = lat;
        this.lng = lng;
        this.locality = locality;
        this.name = name;
        this.explanation = explanation;
        this.isVariantOf = isVariantOf;
        this.capacity = capacity;
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
