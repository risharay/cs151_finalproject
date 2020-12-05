package cs151_finalproject.controller;

@SuppressWarnings("serial")
public class ReviewMadeMessage implements Message {
    private boolean confirm;

    public ReviewMadeMessage(boolean bool) { 
        confirm = bool;
    }

    public boolean getMsg() {
        return confirm;
    }
}
