package cs151_finalproject.controller;

/**
 * Review Made Message
 */
@SuppressWarnings("serial")
public class ReviewMadeMessage implements Message {
    private transient String confirm;

    /**
     * Review Made Message Constructor
     * @param review
     */
    public ReviewMadeMessage(String review) { 
        confirm = review;
    }

    /**
     * Get Message
     * @return String confirm
     */
    public String getMsg() {
        return confirm;
    }

}
