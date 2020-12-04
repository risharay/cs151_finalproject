package cs151_finalproject.controller;

import java.io.Serializable;

/**
 * Represents message (event) sent from View to Model
 */
public interface Message extends Serializable {
    public boolean getMsg();

}

