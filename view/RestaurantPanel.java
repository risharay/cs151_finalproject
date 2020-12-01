import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;

public class RestaurantPanel extends JFrame
{
    public static ArrayList<Restaurant> restaurants = new ArrayList<>();

    private JLabel search = new JLabel("Filter By:");
    private JButton filter = new JButton("Filter");
    private String[] filterOptions = {"Cuisine", "Location", "Rating"};
    private JComboBox comboBox = new JComboBox(filterOptions);

    JList<Restaurant> list = new JList<>();
    DefaultListModel<Restaurant> model = new DefaultListModel<>();
    JFrame frame = new JFrame();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    public RestaurantPanel()
    {
        panel1.setLayout(new FlowLayout());
        panel1.add(search);
        panel1.add(comboBox);
        panel1.add(filter);

        list.setModel(model);
        for(Restaurant r : restaurants)
        {
            model.addElement(r);
        }
        JScrollPane listScroller = new JScrollPane();
        listScroller.setViewportView(list);
        list.setLayoutOrientation(JList.VERTICAL);
        panel2.add(listScroller);

        filter.addActionListener(filter -> updateList());

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(panel1);
        frame.add(panel2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void updateList()
    {
        this.model.removeAllElements();

        if(comboBox.getSelectedItem().equals("Cuisine"))
        {
            Collections.sort(restaurants, new RestaurantCuisineComparator());
            for(Restaurant r : restaurants)
            {
                model.addElement(r);
            }
        }

        if(comboBox.getSelectedItem().equals("Location"))
        {
            Collections.sort(restaurants, new RestaurantLocationComparator());
            for(Restaurant r : restaurants)
            {
                model.addElement(r);
            }
        }

        if(comboBox.getSelectedItem().equals("Rating"))
        {
            Collections.sort(restaurants, new RestaurantRatingComparator());
            for(Restaurant r : restaurants)
            {
                model.addElement(r);
            }
        }
    }

    public static void main(String[] args) {
        restaurants.add(new Restaurant("Panda Express", "Chinese", 3, 3.5));
        restaurants.add(new Restaurant("Spartan Tacos", "Mexican", 4, 5.0));
        restaurants.add(new Restaurant("Jack in the Box", "Fast Food", 1, 2.3));
        restaurants.add(new Restaurant("Iguanas", "Mexican", 2, 4.5));
        restaurants.add(new Restaurant("McDonald's", "Fast Food", 1, 2.1));
        restaurants.add(new Restaurant("In-n-Out", "Fast Food", 5, 4.8));
        restaurants.add(new Restaurant("La Vic's", "Mexican", 2, 3.8));
        restaurants.add(new Restaurant("PF Chang's", "Chinese", 3, 3.7));
        restaurants.add(new Restaurant("King Eggroll", "Chinese", 6, 3.2));

        RestaurantPanel lol = new RestaurantPanel();
    }
}
