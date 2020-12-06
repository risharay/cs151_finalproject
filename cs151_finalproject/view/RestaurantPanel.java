package cs151_finalproject.view;

import cs151_finalproject.model.Model;
import cs151_finalproject.model.Restaurant;
import cs151_finalproject.model.RestaurantCuisineComparator;
import cs151_finalproject.model.RestaurantLocationComparator;
import cs151_finalproject.model.RestaurantRatingComparator;

import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Restaurant Panel where users can search for a restaurant or filter list of restaurants
 */
@SuppressWarnings("serial")
public class RestaurantPanel extends JFrame
{
    public static List<Restaurant> restaurants = new ArrayList<>();

    private JLabel search = new JLabel("Search Name:");
    private JTextField searchBar = new JTextField(20);
    private JButton filter = new JButton("Filter");
    private String[] filterOptions = {"Cuisine", "Location", "Rating"};
    private JComboBox comboBox = new JComboBox(filterOptions);

    JList<Restaurant> list = new JList<>();
    DefaultListModel<Restaurant> model = new DefaultListModel<>();
    JFrame frame = new JFrame();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    /**
     * Design and functions for the Restaurant Panel
     * @param mainModel the main model of the restaurant panel
     */
    public RestaurantPanel(Model mainModel)
    {        
        View.setJFrame(this);
        setRestaurants(Model.getRestaurants());
        panel1.setLayout(new FlowLayout());
        panel1.add(search);
        panel1.add(searchBar);
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

        list.getSelectionModel().addListSelectionListener(e -> {
            View.changeFrame(this.frame, new IndividualRestaurantPanel(list.getSelectedValue()));
        });

        panel2.add(listScroller);

        filter.addActionListener(filter -> updateList());

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setSize(500,500);
        frame.add(panel1);
        frame.add(panel2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Restaurant List update process when user presses filter button
     */
    private void updateList()
    {
        this.model.removeAllElements();

        if(!searchBar.getText().isBlank())
        {
            String restaurantName = searchBar.getText();
            for(Restaurant r : restaurants)
            {
                if(restaurantName.compareTo(r.getName()) == 0) {
                    model.addElement(r);
                }
            }
        }
        else if(comboBox.getSelectedItem().equals("Cuisine"))
        {
            Collections.sort(restaurants, new RestaurantCuisineComparator());
            for(Restaurant r : restaurants)
            {
                model.addElement(r);
            }
        }

        else if(comboBox.getSelectedItem().equals("Location"))
        {
            Collections.sort(restaurants, new RestaurantLocationComparator());
            for(Restaurant r : restaurants)
            {
                model.addElement(r);
            }
        }

        else if(comboBox.getSelectedItem().equals("Rating"))
        {
            Collections.sort(restaurants, new RestaurantRatingComparator());
            for(Restaurant r : restaurants)
            {
                model.addElement(r);
            }
        }
    }
/**
 * Adds the reservation to Reservation
 * @param res reservation from the list of reservations
 */
    private static void setRestaurants(List<Restaurant> res) {
        for(Restaurant r : res) {
            restaurants.add(r);
        }
    }
}
