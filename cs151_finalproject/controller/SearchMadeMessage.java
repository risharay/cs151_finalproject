package cs151_finalproject.controller;

@SuppressWarnings("serial")
public class SearchMadeMessage implements Message {
    private boolean confirm;

    public SearchMadeMessage(boolean bool) { 
        confirm = bool;
    }

    public boolean getMsg() {
        return confirm;
    }
}
