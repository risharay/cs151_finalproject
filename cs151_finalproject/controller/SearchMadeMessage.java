package cs151_finalproject.controller;

@SuppressWarnings("serial")
public class SearchMadeMessage implements Message {
    private transient String input;

    public SearchMadeMessage(String string) { 
        input = string;
    }

    public String getMsg() {
        return input;
    }

}
