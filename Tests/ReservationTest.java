import cs151_finalproject.model.Reservation;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationTest
{
    cs151_finalproject.model.Reservation reservation = new Reservation(3, "Jack");

    @Test
    public void testGetPartySize()
    {
        assertEquals(reservation.getPartySize(), 3, "getPartySize() should return 3");
    }

    @Test
    public void testGetPartyName()
    {
        assertEquals(reservation.getPartyName(), "Jack");
    }

    @Test
    public void testSetPartySize()
    {
        reservation.setPartySize(5);
        assertEquals(reservation.getPartySize(), 5, "getPartySize() should return 3");
    }

    @Test
    public void testSetPartyName()
    {
        reservation.setPartyName("Jill");
        assertEquals(reservation.getPartyName(), "Jill");
    }
}
