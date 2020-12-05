package cs151_finalproject.view;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class IndividualRestaurantPanel extends JFrame {

    private JButton seeReviews;
    private JButton makeReservation;
    private JButton back;
    private JLabel restaurantName = new JLabel("Taco Bell ");
    private JLabel restaurantLocation = new JLabel("San Jose, CA ");
    private JLabel restaurantRating = new JLabel("Rating: 3 ");
    JPanel restaurantInformationPanel = new JPanel();
    JFrame frame = new JFrame();
    JPanel buttons = new JPanel();

    public IndividualRestaurantPanel() {

    	restaurantName.setFont(new Font("Arial", Font.BOLD, 25));
    	restaurantLocation.setFont(new Font("Arial", Font.PLAIN, 15));
    	restaurantRating.setFont(new Font("Arial", Font.PLAIN, 15));
        restaurantInformationPanel.add(restaurantName);
        restaurantInformationPanel.add(restaurantLocation);
        restaurantInformationPanel.add(restaurantRating);
        seeReviews = new JButton("See Reviews");
        makeReservation = new JButton("Make Reservation");
        back = new JButton("Back");
        seeReviews.addActionListener(seeReviews -> seeReviews());
        makeReservation.addActionListener(makeReservation -> makeReservation());
        back.addActionListener(back -> back());

        buttons.add(seeReviews);
        buttons.add(makeReservation);
        buttons.add(back);

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setPreferredSize(new Dimension(500, 500));
        frame.add(restaurantInformationPanel);
        frame.add(buttons);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    private void seeReviews() {


    }

    private void makeReservation() {

    }

    private void back() {

    }

    public static void main(String[] args) {

        IndividualRestaurantPanel individualRestaurantPanel = new IndividualRestaurantPanel();

    }

}


