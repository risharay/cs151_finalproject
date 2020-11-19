public class ReservationManager {
	List<Reservation> reservations;


	public ReservationManager getInstance(){
		if(instance == null){
			instance = new ReservationManager();
		}
		return instance;
	}
	
	private void init(){
		reservations = new ArrayList<>();
		
	}
	
	public void CreateANewReservation(String partyName, int partySize, int reservationId){
		
	}
	
	public boolean makeAReservation(String partyName, int partySize, int reservationId){
		
		if(reservations != null){
			Reservation reservation = new Reservation(eservationId,partySize,partyName);
			return true;
		}
		return false;	
	}