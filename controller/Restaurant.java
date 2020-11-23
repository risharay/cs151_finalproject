package cs151_finalproject.controller;

public class Restaurant
{
    // Variables
    String name;
    String cuisine;
    int location;
    double rating;
    List<Review> reviews = new List<>();
    List<Reservation> reservations = new List<>();

    // Constructor
    public Restaurant(String name, String cuisine, int location, double rating)
    {
        this.name = name;
        this.cuisine = cuisine;
        this.location = location;
        this.rating = rating;
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

    public void setLocation(String location) {
        this.location = location;
    }

    public double getRating() {
        return rating;
    }
    
    public void setRating(double rating) {
        this.rating = rating;
    }

    // Review methods
    public boolean makeReview(int rating, Date date, String comment, String name) {
        Review newReview = Review(rating, date, comment, name);
        reviews.add(newReview);
        return true;
    }

    public double calculateOverallRating() {
        double totalRating = 0;
        for(Review r : reviews) {
            totalRating += r;
        }
        return totalRating;
    }

    // Reservation methods
    public boolean makeAReservation(String partyName, int partySize, int reservationId) {
        Reservation newReservation = new Reservation(reservationId, partySize, partyName);
        reservations.add(newReservation);
        return true;
	}
}
