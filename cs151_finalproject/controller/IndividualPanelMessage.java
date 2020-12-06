package cs151_finalproject.controller;

import javax.swing.JFrame;
import cs151_finalproject.model.Restaurant;

/**
 * Individual Panel Message
 */
@SuppressWarnings("serial")

public class IndividualPanelMessage implements Message {
    private JFrame oldFrame;
    private transient Restaurant curr;

    /**
     * Constructor for Individual Panel Message
     * @param oldFrame
     * @param curr
     */
    public IndividualPanelMessage(JFrame oldFrame, Restaurant curr) { 
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
