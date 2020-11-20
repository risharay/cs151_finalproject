class Reservation{
	int reservationId;
    int partySize;
	String partyName;
	
	public Reservation(int reservationId, int partySize,String partyName){
		this.reservationId = reservationId;
		this.partySize = partySize;
		this.partySize = partySize;
	
	}

    public int getReservationId(){

        return this.reservationId;
    }

    public int getPartySize(){

        return this.partySize;
    }

    public String getPartyName(){

        return this.partyName;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public void setPartySize(int partySize) {
        this.partySize = partySize;
    }
    
    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }


}
