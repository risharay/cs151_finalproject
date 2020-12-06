import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestaurantTest
{
    cs151_finalproject.model.Restaurant restaurant = new cs151_finalproject.model.Restaurant("Panda Express", "Chinese");

    @Test
    public void testGetName()
    {
        assertEquals(restaurant.getName(), "Panda Express");
    }

    @Test
    public void testGetCuisine()
    {
        assertEquals(restaurant.getCuisine(), "Chinese");
    }

    @Test
    public void testSetName()
    {
        restaurant.setName("Chili's");
        assertEquals(restaurant.getName(), "Chili's");
    }

    @Test
    public void testSetCuisine()
    {
        restaurant.setCuisine("TexMex");
        assertEquals(restaurant.getCuisine(), "TexMex");
    }

    @Test
    public void testSetDistance()
    {
        restaurant.setDistance(9);
        assertEquals(restaurant.getDistance(), 9, "getDisntance() should return 9");
    }

    @Test
    public void testSetRating()
    {
        restaurant.setRating(5);
        assertEquals(restaurant.getRating(), 5, "getRating() should return 5");
    }
}
