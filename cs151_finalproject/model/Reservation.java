package cs151_finalproject.model;

public class Reservation{
    // Variables
    int reservationId;
    int partySize;
    String partyName;

    // Constructor
    public Reservation(int reservationId, int partySize,String partyName){
        this.reservationId = reservationId;
        this.partySize = partySize;
        this.partyName = partyName;
    }

    // Getters and setters
    public int getReservationId(){

        return reservationId;
    }
    public void setReservationId(int reservationId){
        this.reservationId = reservationId;
    }

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
}
