package pl.java.travelapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.java.travelapp.model.enums.AttractionType;
import pl.java.travelapp.validators.ValueOfEnum;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.util.stream.Stream;

@Entity
public class TravelAttraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_travel_attraction")
    private Long id;
    @NotBlank
    private String name;
    private String description;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "location_id")
    private Location location;
    @Transient
    @ValueOfEnum(enumClass = AttractionType.class)
    private String attractionTypeString;
    private AttractionType type;
    @Max(5)
    private double stars;

    public TravelAttraction(){
    }

    public TravelAttraction(Long id, String name, String description, Location location, AttractionType type, double stars,
                            String attractionTypeString) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.type = type;
        this.stars = stars;
        this.attractionTypeString  = attractionTypeString;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
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

    public String getAttractionTypeString() {
        return attractionTypeString;
    }

    public void setAttractionTypeString(String attractionTypeString) {
        this.attractionTypeString = attractionTypeString;
    }
}
