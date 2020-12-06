package cs151_finalproject.controller;

@SuppressWarnings("serial")
public class ReservationMadeMessage implements Message {
    private transient String confirm;

    public ReservationMadeMessage(String reservation) { 
        confirm = reservation;
    }

    public String getMsg() {
        return confirm;
    }
}
