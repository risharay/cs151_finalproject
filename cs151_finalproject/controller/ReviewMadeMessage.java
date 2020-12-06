package cs151_finalproject.controller;

import cs151_finalproject.model.Review;

@SuppressWarnings("serial")
public class ReviewMadeMessage implements Message {
    private transient Review confirm;

    public ReviewMadeMessage(String review) { 
        confirm = review;
    }

    public Review getMsg() {
        return confirm;
    }

}
