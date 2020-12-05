package cs151_finalproject.model;

import java.util.Comparator;

public class RestaurantLocationComparator implements Comparator<Restaurant>
{
    @Override
    public int compare(Restaurant r1, Restaurant r2)
    {
        return r1.getLocation() - r2.getLocation();
    }
}