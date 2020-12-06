package cs151_finalproject.controller;
/**
 * Reservation Made Message
 */
@SuppressWarnings("serial")
public class ReservationMadeMessage implements Message {
    private transient String confirm;

    /**
     * Reservation Made Message constructor
     * @param reservation 
     */
    public ReservationMadeMessage(String reservation) { 
        confirm = reservation;
    }

    /**
     * Get Message
     * @return String  
     */
    public String getMsg() {
        return confirm;
    }
}
