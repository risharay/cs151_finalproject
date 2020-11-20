public class Reservation{
	int reservationId;
    int partySize;
	String partyName;
	
	public Reservation(int reservationId, int partySize,String partyName){
		this.reservationId = reservationId;
		this.partySize = partySize;
		this.partySize = partySize;
	
	}

    public int getReservationId(){

        return reservationId;
    }
     public void setReservationId(){

        this.reservationId = reservationId;
    }

    public int getPartySize(){

        return partySize;
    }
     public void setPartySize(){
         this.partySize = partySize;
    }

    public String getPartyName(){

        return partyName;
    }
    public void setPartyName(){
        this.partyName= partyName;
    }
}
