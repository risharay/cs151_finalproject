import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RestaurantView extends JFrame
{
    public static Jlist list;
    ArrayList<Restaurant> restaurants = new ArrayList<>();

    restaurants.add(new Restaurant("Panda Express", "Chinese", 3, 3.5));
    restaurants.add(new Restaurant("Spartan Tacos", "Mexican", 4, 5.0));
    restaurants.add(new Restaurant("Jack in the Box", "Fast Food", 1, 2.3));
    restaurants.add(new Restaurant("Iguanas", "Mexican", 2, 4.5));
    restaurants.add(new Restaurant("McDonald's", "Fast Food", 1, 2.1));
    restaurants.add(new Restaurant("In-n-Out", "Fast Food", 5, 4.8));
    restaurants.add(new Restaurant("La Vic's", "Mexican", 2, 3.8));
    restaurants.add(new Restaurant("PF Chang's", "Chinese", 3, 3.7));
    restaurants.add(new Restaurant("King Eggroll", "Chinese", 6, 3.2));

    list = new JList(restaurants.toArray());

    public RestaurantView()
    {
        JPanel panel = new JPanel();
        JLabel label = new Label("Restaurant List");
        panel.add(label);
        list.setVisibleRowCount(5);
        JScrollPane scroller = new JScrollPane(list);
        panel.add(scroller);

        JFrame frame = new JFrame();
        frame.setSize(500, 250);
        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}