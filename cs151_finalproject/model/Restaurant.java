package cs151_finalproject.model;

import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;

public class Restaurant implements Comparable<Restaurant>
{
    // Variables
    String name;
    String cuisine;
    int location;
    double rating;
    private List<Review> reviews = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    // Constructor
    public Restaurant(String name, String cuisine, int location)
    {
        this.name = name;
        this.cuisine = cuisine;
        this.location = location;
        setRating(0);
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public double getRating() {
        return rating;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    // Review methods
    public void makeReview(Review r) {
        reviews.add(r);
        calculateOverallRating();
    }

    public void calculateOverallRating() {
        double totalRating = 0;
        for(Review r : reviews)
        {
            totalRating += r.getRating();
        }
        setRating(totalRating);
    }

    // Reservation methods
    public boolean makeAReservation(String partyName, int partySize, int reservationId) {
        Reservation newReservation = new Reservation(reservationId, partySize, partyName);
        reservations.add(newReservation);
        return true;
    }

    @Override
    public int compareTo(Restaurant other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Restaurant) {
            Restaurant other = (Restaurant) obj;
            return this.name == other.name ;
        }
        return false;
    }

    @Override
    public String toString() {
        return name + ", Cuisine = " + cuisine + ", " + location + " miles, " + rating + "/5";
    }
    
}