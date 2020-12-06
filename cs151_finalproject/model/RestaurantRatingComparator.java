package cs151_finalproject.model;

import java.util.Comparator;

/**
 * Restaurant Rating Comparator
 */
public class RestaurantRatingComparator implements Comparator<Restaurant>
{
	/**
     * Compares the restaurants ratings
     * @param r1 first restaurant
     * @param r2 second restaurant
     * @return int 
     */
    public int compare(Restaurant r1, Restaurant r2)
    {
        return -(Double.compare(r1.getRating(), r2.getRating()));
    }
}
