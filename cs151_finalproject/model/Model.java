package cs151_finalproject.model;

import java.util.*;

public class Model {
    List<Restaurant> restaurants = new ArrayList<>();
    String[] cuisine = {"Chinese", "Mexican", "Fast Food", "Korean", "Japanese"};

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
        restaurants.add(new Restaurant("Ramen Nagi", cuisine[5]));
        restaurants.add(new Restaurant("Kami Kitchen", cuisine[4]));
        restaurants.add(new Restaurant("Tofu House", cuisine[4]));
        restaurants.add(new Restaurant("Kenzo Sushi", cuisine[5]));
        restaurants.add(new Restaurant("Sodam", cuisine[4]));
        restaurants.add(new Restaurant("Bonchon", cuisine[4]));
        restaurants.add(new Restaurant("Mayflower", cuisine[1]));
    }
}
