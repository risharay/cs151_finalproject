public class Model {
    Reservation reservation;
    Restaurant restaurant;
    Review review;

    public class Reservation {
        int reservationId;
        int partySize;
        String partyName;

        public int getReservationId() {

            return reservationId;
        }

        public void setReservationId(int reservationId) {
            this.reservationId = reservationId;
        }

        public int getPartySize() {

            return partySize;
        }

        public void setPartySize(int partySize) {
            this.partySize = partySize;
        }

        public String getPartyName() {

            return partyName;
        }

        public void setPartyName(String partyName) {
            this.partyName = partyName;
        }
    }

    public class Restaurant {
        String name;
        String cuisine;
        int location;
        double rating;
        List<Review> reviews = new ArrayList<>();
        List<Reservation> reservations = new ArrayList<>();

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

        public void setRating(double rating) {
            this.rating = rating;
        }
    }

    public class Review {
        int rating;
        String comment;
        String name;

        public int getRating() {
            return rating;
        }
        
        public String getComment() {
            return comment;
        }

        public String getName() {
            return name;
        }


        public void setRating(int rating) {
            this.rating = rating;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
