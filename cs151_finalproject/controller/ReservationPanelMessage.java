package cs151_finalproject.controller;

@SuppressWarnings("serial")
public class ReservationPanelMessage implements Message {
    private boolean confirm;

    public ReservationPanelMessage(boolean bool) { 
        confirm = bool;
    }

    public boolean getMsg() {
        return confirm;
    }
}
