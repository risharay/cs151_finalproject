package cs151_finalproject.model;

import java.util.Comparator;

public class RestaurantLocationComparator implements Comparator<Restaurant>
{
    @Override
    public int compare(Restaurant r1, Restaurant r2)
    {
        return Double.compare(r1.getDistance(), r2.getDistance());
    }
}