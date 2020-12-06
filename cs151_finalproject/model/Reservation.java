package cs151_finalproject.model;

public class Reservation{
    // Variables
    int partySize;
    String partyName;

    // Constructor
    public Reservation(int partySize,String partyName){
        this.partySize = partySize;
        this.partyName = partyName;
    }

    // Getters and setters
    public int getPartySize(){

        return partySize;
    }
    public void setPartySize(int partySize){
        this.partySize = partySize;
    }

    public String getPartyName(){

        return partyName;
    }
    public void setPartyName(String partyName){
        this.partyName= partyName;
    }
    
    @Override
    public String toString() {
        return "<html>Party Name: " + this.partyName + "<br>Party Size: " + this.partySize + "</html>";
    }
}
