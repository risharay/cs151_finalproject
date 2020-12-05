package cs151_finalproject.controller;

public class ReviewPanelMessage implements Message {
    private boolean confirm;

    public ReviewPanelMessage(boolean bool) { 
        confirm = bool;
    }

    public boolean getMsg() {
        return confirm;
    }
}
