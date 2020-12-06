package cs151_finalproject.model;

import java.util.Comparator;

/**
 * Restaurant Location Comparator
 */
public class RestaurantLocationComparator implements Comparator<Restaurant>
{
	/**
     * Compares the restaurants locations
     * @param r1 first restaurant
     * @param r2 second restaurant
     * @return int 
     */
	@Override
    public int compare(Restaurant r1, Restaurant r2)
    {
        return Double.compare(r1.getDistance(), r2.getDistance());
    }
}