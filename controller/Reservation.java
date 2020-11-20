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
     public void setReservationId(reservationId){
        this.reservationId = reservationId;
    }

    public int getPartySize(){

        return partySize;
    }
     public void setPartySize(partySize){
         this.partySize = partySize;
    }

    public String getPartyName(){

        return partyName;
    }
    public void setPartyName(partyName){
        this.partyName= partyName;
    }
}
