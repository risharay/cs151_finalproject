package cs151_finalproject.controller;

import javax.swing.JFrame;
import cs151_finalproject.model.Restaurant;

/**
 * Reservation Panel Message
 */
@SuppressWarnings("serial")
public class ReservationPanelMessage implements Message {
    private JFrame oldFrame;
    private transient Restaurant curr;

    /**
     * Constructor for Reservation Panel Message
     * @param oldFrame
     * @param curr
     */
    public ReservationPanelMessage(JFrame oldFrame, Restaurant curr) { 
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
