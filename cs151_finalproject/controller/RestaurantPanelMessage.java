package cs151_finalproject.controller;

/**
 * Restaurant Panel Message
 */
import javax.swing.JFrame;
import cs151_finalproject.model.Restaurant;

@SuppressWarnings("serial")
public class RestaurantPanelMessage implements Message {
    private JFrame oldFrame;
    private transient Restaurant curr;

    /**
     * Constructor for  Restaurant Panel Message
     * @param oldFrame
     * @param curr
     */
    public RestaurantPanelMessage(JFrame oldFrame, Restaurant curr) { 
        this.oldFrame = oldFrame;
        this.curr = curr;
    }

    /**
     * Get old frame
     * @return JFrame old frame
     */
    public JFrame getOldFrame() {
        return oldFrame;
    }

    /**
     * Get Current
     * @return Restaurant curr
     */
    public Restaurant getCurr() {
        return curr;
    }
}
