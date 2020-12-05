package cs151_finalproject.model;

import java.util.Comparator;

public class RestaurantRatingComparator implements Comparator<Restaurant>
{
    public int compare(Restaurant r1, Restaurant r2)
    {
        return (int) -(r1.getRating() - r2.getRating());
    }
}
