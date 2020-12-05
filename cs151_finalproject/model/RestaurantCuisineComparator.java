package cs151_finalproject.model;

import java.util.Comparator;

public class RestaurantCuisineComparator implements Comparator<Restaurant>
{
    public int compare(Restaurant r1, Restaurant r2)
    {
        return r1.getCuisine().compareTo(r2.getCuisine());
    }
}
