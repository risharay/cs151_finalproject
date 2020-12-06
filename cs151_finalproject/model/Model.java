package cs151_finalproject.model;

import java.util.*;

/**
 * Model
 */
public class Model {
    static List<Restaurant> restaurants = new ArrayList<>();
    String[] cuisine = {"Japanese", "Chinese", "Mexican", "Fast Food", "Korean"};

    public Model() {
        restaurants.add(new Restaurant("Panda Express", cuisine[1]));
        restaurants.add(new Restaurant("Spartan Tacos", cuisine[2]));
        restaurants.add(new Restaurant("Jack in the Box", cuisine[3]));
        restaurants.add(new Restaurant("Iguanas", cuisine[2]));
        restaurants.add(new Restaurant("McDonald's", cuisine[3]));
        restaurants.add(new Restaurant("In-n-Out", cuisine[3]));
        restaurants.add(new Restaurant("La Vic's", cuisine[2]));
        restaurants.add(new Restaurant("PF Chang's", cuisine[1]));
        restaurants.add(new Restaurant("King Eggroll", cuisine[1]));
        restaurants.add(new Restaurant("Ramen Nagi", cuisine[0]));
        restaurants.add(new Restaurant("Kami Kitchen", cuisine[4]));
        restaurants.add(new Restaurant("Tofu House", cuisine[4]));
        restaurants.add(new Restaurant("Kenzo Sushi", cuisine[0]));
        restaurants.add(new Restaurant("Sodam", cuisine[4]));
        restaurants.add(new Restaurant("Bonchon", cuisine[4]));
        restaurants.add(new Restaurant("Mayflower", cuisine[1]));
        
//        System.out.println(restaurants.size());
//        for(Restaurant r:restaurants)
//        	System.out.println(r);
    }

<<<<<<< HEAD
    /**
     * Gets restaurants
     * @return List<Restaurant> 
     */
=======
>>>>>>> c0d7879c0897da209f2189888a289f2ff93a9a85
    public static List<Restaurant> getRestaurants() {
        return restaurants;
    }

}
