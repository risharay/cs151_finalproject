package cs151_finalproject.model;

import java.util.*;
import java.security.SecureRandom;

/**
 * Restaurant Class
 * implements Comparable
 */
public class Restaurant implements Comparable<Restaurant>
{
    // Variables
    String name;
    String cuisine;
    double distance;
    double rating;
    private List<Review> reviews = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    /**
     * Constructor
     * @param name
     * @param cuisine
     */
    public Restaurant(String name, String cuisine)
    {
        this.name = name;
        this.cuisine = cuisine;
        this.distance = randomLocation();
        setRating(0);
        reviewGenerator();
        reservationGenerator();
    }

    /**
     * Gets the name
     * @return String the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the cuisine
     * @return String the cuisine
     */
    public String getCuisine() {
        return cuisine;
    }

    /**
     * Sets the cuisine
     * @param cuisine
     */
    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }
    
    /**
     * Gets the distance
     * @return double the distance
     */
    public double getDistance() {
        return distance;
    }
    
    /**
     * Sets the distance
     * @param distance 
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * Gets the rating
     * @return String the rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * Gets the reviews
     * @return List<Review> the list of reviews
     */
    public List<Review> getReviews() {
        return reviews;
    }
    
    /**
     * Gets the reservations
     * @return List<Reservation> the list of reservations
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Sets the rating
     * @param rating
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Makes the reviews
     * @return r review
     */
    public void makeReview(Review r) {
        reviews.add(r);
        calculateOverallRating();
    }

    /**
     * Calculates overall rating
     */
    public void calculateOverallRating() {
        double totalRating = 0;
        double count = 0;
        for(Review r : reviews)
        {
            totalRating += r.getRating();
            count+= 1.0;
        }
        if(count == 0)
            totalRating = 0;
        else
            totalRating = totalRating / count;

        int truncator = (int)( totalRating * Math.pow( 10, 1 ) );
        totalRating = (double)( truncator / Math.pow( 10, 1) );

        setRating(totalRating);
    }
   
    /**
     * Makes the reservation
     * @param newReservation
     * @return boolean
     */
    // Reservation methods
    public boolean makeReservation(Reservation newReservation) {
        reservations.add(newReservation);
        return true;
    }
    
    /**
     * Compares the restaurants
     * @param other 
     * @return int 
     */
    @Override
    public int compareTo(Restaurant other) {
        return this.name.compareTo(other.name);
    }

    /**
     * Equals method
     * @param obj 
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Restaurant) {
            Restaurant other = (Restaurant) obj;
            return this.name == other.name ;
        }
        return false;
    }

    /**
     * To String method
     * @return String
     */
    @Override
    public String toString() {
        return name + ", Cuisine: " + cuisine + ", " + distance + " miles away, " + rating + "/5";
    }
    
    /**
     * Reviews Generator
     */
    // database generator
    private void reviewGenerator() {
        List<Review> fakeReviews = new ArrayList<>();

        fakeReviews.add(new Review(5, "Perfect dishes!", "John Doe"));
        fakeReviews.add(new Review(4, "So-so food, but great people.", "Jane Doe"));
        fakeReviews.add(new Review(1, "Abolutely horrible food.", "Sasha Lin"));
        fakeReviews.add(new Review(3, "Quality was alright.", "Betty White"));
        fakeReviews.add(new Review(5, "I had a wonderful time here.", "Eric Nguyen"));
        fakeReviews.add(new Review(3, "Mediocre food, but I've had worse", "Alan Kong"));
        fakeReviews.add(new Review(2, "Horrible wait time and rude, but food OK.", "Terilyn Tran"));
        fakeReviews.add(new Review(4, "Not very clean, but good food.", "Katherine Byun"));

        Random rand = new SecureRandom();
        for(int i = 0; i < rand.nextInt(8); i++) {
            int num = rand.nextInt(8);
            this.makeReview(fakeReviews.get(num));
        }
    }
    /**
     * Reservation Generator
     */
    private void reservationGenerator() {
        List<Reservation> fakeReservations = new ArrayList<>();

        fakeReservations.add(new Reservation(4, "Aaron Kim"));
        fakeReservations.add(new Reservation(7, "Sara Bennett"));
        fakeReservations.add(new Reservation(2, "Mary Chou"));
        fakeReservations.add(new Reservation(1, "Zachary James"));
        fakeReservations.add(new Reservation(2, "Monica Liu"));
        fakeReservations.add(new Reservation(4, "Steven Wu"));
        fakeReservations.add(new Reservation(2, "Michael Su"));
        fakeReservations.add(new Reservation(2, "Kevin Miller"));

        Random rand = new SecureRandom();
        for(int i = 0; i < rand.nextInt(8); i++) {
            int num = rand.nextInt(8);
            this.makeReservation(fakeReservations.get(num));
        }
    }

    /**
     * Random Location
     * @return double 
     */
    public static double randomLocation() {
        double scale = Math.pow(10, 2);
        double random = Math.random() * 15 + 1;
        return Math.round(random * scale) / scale;
    }
}