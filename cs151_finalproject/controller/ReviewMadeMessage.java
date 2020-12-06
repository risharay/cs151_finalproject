package cs151_finalproject.controller;

@SuppressWarnings("serial")
public class ReviewMadeMessage implements Message {
    private transient String confirm;

    public ReviewMadeMessage(String review) { 
        confirm = review;
    }

    public String getMsg() {
        return confirm;
    }

}
