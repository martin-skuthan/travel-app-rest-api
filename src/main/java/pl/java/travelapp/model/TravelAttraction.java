package pl.java.travelapp.model;

import pl.java.travelapp.model.enums.AttractionType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TravelAttraction {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String location;
    private AttractionType type;
    private double stars;

    public TravelAttraction(){}

    public TravelAttraction(Long id, String name, String description, String location, AttractionType type, double stars) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.type = type;
        this.stars = stars;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public AttractionType getType() {
        return type;
    }

    public void setType(AttractionType type) {
        this.type = type;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }
}
