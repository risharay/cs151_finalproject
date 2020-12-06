import cs151_finalproject.model.Review;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReviewTest
{
    cs151_finalproject.model.Review review = new Review(4, "Amazing food!", "Khloe");

    @Test
    public void testGetRating()
    {
        assertEquals(review.getRating(), 4, "getRating() should return 4");
    }

    @Test
    public void testGetComment()
    {
        assertEquals(review.getComment(), "Amazing food!");
    }

    @Test
    public void testGetName()
    {
        assertEquals(review.getName(), "Khloe");
    }

    @Test
    public void testSetRating()
    {
        review.setRating(2);
        assertEquals(review.getRating(), 2, "getRating() should return 2");
    }

    @Test
    public void testSetComment()
    {
        review.setComment("Absolutely terrible food.");
        assertEquals(review.getComment(), "Absolutely terrible food.");
    }

    @Test
    public void testSetName()
    {
        review.setName("Kourtney");
        assertEquals(review.getName(), "Kourtney");
    }
}
