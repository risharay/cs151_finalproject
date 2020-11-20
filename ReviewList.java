public class ReviewList {
    List<Review> reviews;

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
    
}
