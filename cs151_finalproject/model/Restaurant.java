package cs151_finalproject.model;

import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;

public class Restaurant implements Comparable<Restaurant>
{
    // Variables
    String name;
    String cuisine;
    int distance;
    double rating;
    private List<Review> reviews = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    // Constructor
    public Restaurant(String name, String cuisine)
    {
        this.name = name;
        this.cuisine = cuisine;
        this.distance = randomLocation();
        setRating(0);
        reviewGenerator();
        reservationGenerator();
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

    public int getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
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
    public boolean makeReservation(Reservation newReservation) {
        newReservation.setReservationId(reservations.size());
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
        return name + ", Cuisine = " + cuisine + ", " + distance + " miles away, " + rating + "/5";
    }
    
    // database generator
    private void reviewGenerator() {
        List<Review> fakeReviews = new ArrayList<>();

        fakeReviews.add(new Review(5, "Perfect dishes!", "John Doe"));
        fakeReviews.add(new Review(4, "So-so food, but great people.", "Jane Doe"));
        fakeReviews.add(new Review(1, "Abolutely horrible food. Hated the service.", "Sasha Lin"));
        fakeReviews.add(new Review(3, "Quality was alright, but I wouldn't return again.", "Betty White"));
        fakeReviews.add(new Review(5, "I had a wonderful time here. Will definitely be coming back with my friends.", "Eric Nguyen"));
        fakeReviews.add(new Review(3, "Mediocore food, but I've had worse", "Alan Kong"));
        fakeReviews.add(new Review(2, "Horrible wait time and the waiter was rude, but food OK.", "Terilyn Tran"));
        fakeReviews.add(new Review(4, "The restaurant wasn't the cleanest, but best food I've ever had.", "Katherine Byun"));

        for(int i = 0; i < (Math.random() * 8 + 1); i++) 
            this.makeReview(fakeReviews.get(i));
    }

    private void reservationGenerator() {
        List<Reservation> fakeReservations = new ArrayList<>();

        fakeReservations.add(new Reservation(4, "Aaron Kim"));
        fakeReservations.add(new Reservation(4, "Sara Bennett"));
        fakeReservations.add(new Reservation(4, "Mary Chou"));
        fakeReservations.add(new Reservation(4, "Zachary James"));
        fakeReservations.add(new Reservation(4, "Monica Liu"));
        fakeReservations.add(new Reservation(4, "Steven Wu"));
        fakeReservations.add(new Reservation(4, "Michael Su"));
        fakeReservations.add(new Reservation(4, "Kevin Miller"));

        for(int i = 0; i < (Math.random() * 8 + 1); i++) 
            this.makeReservation(fakeReservations.get(i));
    }

    public static double randomLocation() {
        double scale = Math.pow(10, 2);
        double random = Math.random() * 15 + 1;
        return Math.round(random * scale) / scale;
    }
}