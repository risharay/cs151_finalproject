// import java.util.Date;  

public class Review {
    // Variables
    int rating;
    // Date date;
    String comment;
    String name;

    // Constructor
    public Review(int rating, String comment, String name){
		this.rating = rating;
		// this.date = date;
        this.comment = comment;
        this.name = name;
    }
    
    // Getters 
    public int getRating() {
        return rating;
    }

    // public Date getDate() {
    //     return date;
    // }

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

    // public void setDate(Date date) {
    //     this.date = date;
    // }

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
