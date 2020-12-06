package cs151_finalproject.model;

import java.util.Comparator;

/**
 * Restaurant Cuisine Comparator
 */
public class RestaurantCuisineComparator implements Comparator<Restaurant>
{
	 /**
     * Compares the restaurants
     * @param r1 first restaurant
     * @param r2 second restaurant
     * @return int 
     */
    public int compare(Restaurant r1, Restaurant r2)
    {
        return r1.getCuisine().compareTo(r2.getCuisine());
    }
}
