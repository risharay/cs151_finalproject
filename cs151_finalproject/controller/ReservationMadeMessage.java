package cs151_finalproject.controller;

import cs151_finalproject.model.Reservation;

@SuppressWarnings("serial")
public class ReservationMadeMessage implements Message {
    private transient Reservation confirm;

    public ReservationMadeMessage(String reservation) { 
        confirm = reservation;
    }

    public Reservation getMsg() {
        return confirm;
    }
}
