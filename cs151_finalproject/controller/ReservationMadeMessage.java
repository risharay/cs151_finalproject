package cs151_finalproject.controller;

public class ReservationMadeMessage implements Message {
    private boolean confirm;

    public ReservationMadeMessage(boolean bool) { 
        confirm = bool;
    }

    public boolean getMsg() {
        return confirm;
    }
}
