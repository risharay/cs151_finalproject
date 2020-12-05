package cs151_finalproject.controller;

@SuppressWarnings("serial")
public class RestaurantPanelMessage implements Message {
    private boolean confirm;

    public RestaurantPanelMessage(boolean bool) { 
        confirm = bool;
    }

    public boolean getMsg() {
        return confirm;
    }
}
