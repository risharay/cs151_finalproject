package cs151_finalproject.controller;

import javax.swing.JFrame;
import cs151_finalproject.model.Restaurant;

public class IndividualPanelMessage {
    private JFrame oldFrame;
    private Restaurant curr;

    public IndividualPanelMessage(JFrame oldFrame, Restaurant curr) { 
        this.oldFrame = oldFrame;
        this.curr = curr;
    }

    public JFrame getOldFrame() {
        return oldFrame;
    }

    public Restaurant getCurr() {
        return curr;
    }
}
