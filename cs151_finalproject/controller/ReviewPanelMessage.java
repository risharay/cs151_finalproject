package cs151_finalproject.controller;

import javax.swing.JFrame;
import cs151_finalproject.model.Restaurant;

/**
 * Review Panel Message
 */
@SuppressWarnings("serial")
public class ReviewPanelMessage implements Message {
    private JFrame oldFrame;
    private transient Restaurant curr;

    /**
     * Constructor Review Panel Message
     * @param oldFrame
     * @param curr
     */
    public ReviewPanelMessage(JFrame oldFrame, Restaurant curr) { 
        this.oldFrame = oldFrame;
        this.curr = curr;
    }
    
    /**
     * Get Old Frame
     * return JFrame old frame
     */
    public JFrame getOldFrame() {
        return oldFrame;
    }
    
    /**
     * Get current
     * @Restaurant curr
     */
    public Restaurant getCurr() {
        return curr;
    }
}
