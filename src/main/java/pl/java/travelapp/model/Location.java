package pl.java.travelapp.model;

public class Location {
    private String city;
    private String street;
    private String country;
    private String postalCode;

    public Location(String city, String street, String country, String postalCode) {
        this.city = city;
        this.street = street;
        this.country = country;
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
