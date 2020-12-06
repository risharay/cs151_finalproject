package cs151_finalproject.model;

/**
 * Review Class
 */
public class Review {
    // Variables
    int rating;
    String comment;
    String name;

    /**
     * Review Constructor
     * @param rating
     * @param comment
     * param name
     */
    public Review(int rating, String comment, String name){
		this.rating = rating;
        this.comment = comment;
        this.name = name;
    }
    
    /**
     * Get rating
     * @return int 
     */
    public int getRating() {
        return rating;
    }
    
    /**
     * Get comment
     * @return String 
     */
    public String getComment() {
        return comment;
    }

    /**
     * Get name
     * @return String 
     */
    public String getName() {
        return name;
    }

    /**
     * Set rating
     * @param rating 
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Set Comment
     * @param comment 
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    /**
     * Set Name
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "<html>Name: " + this.name + "<br>Rating: " + this.rating + "<br>Review: " + this.comment + "</html>";
    }
}
