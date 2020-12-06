package cs151_finalproject.model;
    /**
    * Reservation Class
    */
public class Reservation{
    // Variables
    int reservationId;
    int partySize;
    String partyName;

    /**
    * Constructor
    * @param partySize size of party
    * @param partyName name of party
    */
    public Reservation(int partySize,String partyName){
        this.partySize = partySize;
        this.partyName = partyName;
    }

    /**
    * Gets Reservation Id
    * @return int reservationId
    */
    public int getReservationId(){

        return reservationId;
    }

    /**
    * Sets Reservation Id
    * @param reservationId the reservation Id
    */
    public void setReservationId(int reservationId){
        this.reservationId = reservationId;
    }

    /**
    * Gets Party Size
    * @return int party size
    */
    public int getPartySize(){

        return partySize;
    }

    /**
    * Sets Party Size
    * @param reservationId the party size
    */
    public void setPartySize(int partySize){
        this.partySize = partySize;
    }
   
    /**
    * Gets Party Name
    * @return String party name
    */
    public String getPartyName(){

        return partyName;
    }
    
    /**
     * Sets Party Name
     * @param partyName the party name
     */
    public void setPartyName(String partyName){
        this.partyName= partyName;
    }
    
    @Override
    public String toString() {
        return "<html>Party Name: " + this.partyName + "<br>Party Size: " + this.partySize + "<br>Number of Parties Waiting: " + this.reservationId + "</html>";
    }
}
