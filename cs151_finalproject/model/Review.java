package cs151_finalproject.model;

public class Review {
    // Variables
    int rating;
    String comment;
    String name;

    // Constructor
    public Review(int rating, String comment, String name){
		this.rating = rating;
        this.comment = comment;
        this.name = name;
    }
    
    // Getters 
    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public String getName() {
        return name;
    }

    // Setters
    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "<html>Name: " + this.name + "<br>Rating: " + this.rating + "<br>Review: " + this.comment + "</html>";
    }
}
