package cs151_finalproject.view;

import cs151_finalproject.model.Restaurant;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

@SuppressWarnings("serial")
public class IndividualRestaurantPanel extends JFrame {
    private JButton seeReviews;
    private JButton makeReservation;
    private JButton back;
    private JLabel restaurantName;
    private JLabel restaurantDistance;
    private JLabel restaurantRating;
    JPanel restaurantInformationPanel = new JPanel();
    JFrame frame = new JFrame();
    JPanel buttons = new JPanel();

    String arial = "Arial";

    public IndividualRestaurantPanel(Restaurant restaurant) {
    	View.setCurr(restaurant);
    	
        restaurantName = new JLabel(restaurant.getName());
        restaurantDistance = new JLabel(String.valueOf(restaurant.getDistance()) + " miles away");
        restaurantRating = new JLabel("Rating: " + restaurant.getRating());

    	restaurantName.setFont(new Font(arial, Font.BOLD, 40));
    	restaurantDistance.setFont(new Font(arial, Font.PLAIN, 20));
        restaurantRating.setFont(new Font(arial, Font.PLAIN, 20));
        
        restaurantInformationPanel.add(restaurantName);
        restaurantInformationPanel.add(restaurantDistance);
        restaurantInformationPanel.add(restaurantRating);
        restaurantInformationPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        restaurantInformationPanel.setLayout(new BoxLayout(restaurantInformationPanel, BoxLayout.Y_AXIS));
        restaurantInformationPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        seeReviews = new JButton("See Reviews");
        // makeReservation = new JButton("Make Reservation");
        // back = new JButton("Back");
        // seeReviews.addActionListener(seeReviews -> seeReviews());
        // makeReservation.addActionListener(makeReservation -> makeReservation());
        // back.addActionListener(back -> back());

        buttons.add(seeReviews);
        buttons.add(View.viewReservation);
        // buttons.add(back);
        buttons.setAlignmentX(Component.CENTER_ALIGNMENT);

        frame.add(restaurantInformationPanel);
        frame.add(buttons);

        frame.setPreferredSize(new Dimension(500, 500));
        frame.setLayout((LayoutManager) new FlowLayout(FlowLayout.LEFT));
        // frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        View.setJFrame(frame);

    }

    public static void main(String[] args) {
        new IndividualRestaurantPanel(new Restaurant("Panda Express", "Chinese"));
    }

}


