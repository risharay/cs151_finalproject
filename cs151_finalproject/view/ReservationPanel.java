package cs151_finalproject.view;

import cs151_finalproject.model.Model;
import cs151_finalproject.model.Reservation;
import cs151_finalproject.model.Restaurant;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.util.List;
import java.util.ArrayList;
import java.awt.*;

/**
 * Reservation Panel where users can make a reservation for the restaurant
 */
@SuppressWarnings("serial")
public class ReservationPanel extends JFrame {
	private JLabel restaurantName = new JLabel();
    private JLabel titleLabel = new JLabel("Make a Reservation");
    private JLabel partyNameLabel = new JLabel("Party Name: ");
    private JLabel partyNameLabelUpdated = new JLabel();
    private JLabel partySizeLabel = new JLabel("Party Size: ");
    private JLabel partySizeLabelUpdated = new JLabel();
    private JLabel numberOfPartiesLabel = new JLabel("Number of Parties Ahead: ");
    private JLabel numberOfPartiesLabelUpdated = new JLabel();
    private JTextField partyNameField = new JTextField(10);
    private JTextField partySizeField = new JTextField(10);

    int reservationId;
    JFrame frame = new JFrame();
    JPanel partyNamePanel = new JPanel();
    JPanel partyNamePanelUpdated = new JPanel();
    JPanel partySizePanel = new JPanel();
    JPanel partySizePanelUpdated = new JPanel();
    JPanel numberOfPartiesPanel = new JPanel();
    JPanel numberOfPartiesPanelUpdated = new JPanel();

    private JButton confirm;
    private JButton back;

    static List<Reservation> reservations = new ArrayList<>();

    /**
     * Design and functions for the Reservation Panel
     *
     * @param partyName Party Name string
     * @param partySize Party Size int
     */
    public ReservationPanel(Restaurant restaurant) {
        setReservations(restaurant.getReservations());
        
        restaurantName.setText(restaurant.getName());
        restaurantName.setFont(new Font("Arial", Font.BOLD, 30));
        
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBorder(new EmptyBorder(10,0,10,0));

        partyNamePanel.add(partyNameLabel);
        partyNamePanel.add(partyNameField);
        partyNamePanelUpdated.add(partyNameLabelUpdated);

        partySizePanel.add(partySizeLabel);
        partySizePanel.add(partySizeField);
        partySizePanelUpdated.add(partySizeLabelUpdated);

        numberOfPartiesPanel.add(numberOfPartiesLabel);
        numberOfPartiesLabel.setText("Number of Parties Ahead: " + String.valueOf(reservationId));
        
//        JPanel inputs = new JPanel();
//        inputs.add(partyNamePanel);
//        inputs.add(partyNamePanelUpdated);
//        inputs.add(partySizePanel);
//        inputs.add(partySizePanelUpdated);
//        inputs.add(numberOfPartiesPanel);
//        inputs.add(numberOfPartiesPanelUpdated);
//        

        numberOfPartiesPanelUpdated.add(numberOfPartiesLabelUpdated);

        confirm = new JButton("Confirm");
        back = new JButton("Back");
        
        JPanel buttons = new JPanel();
        buttons.add(confirm);
        buttons.add(back);

        confirm.addActionListener(confirm -> updateValues());

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setSize(500, 500);
        frame.add(restaurantName);
        frame.add(titleLabel);
        frame.add(partyNamePanel, JFrame.LEFT_ALIGNMENT);
        frame.add(partyNamePanelUpdated, JFrame.LEFT_ALIGNMENT);
        frame.add(partySizePanel, JFrame.LEFT_ALIGNMENT);
        frame.add(partySizePanelUpdated, JFrame.LEFT_ALIGNMENT);
        frame.add(numberOfPartiesPanel, JFrame.LEFT_ALIGNMENT);
        frame.add(numberOfPartiesPanelUpdated, JFrame.LEFT_ALIGNMENT);
//        frame.add(inputs);
        frame.add(buttons);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    /**
     * Reservation List update process when user presses confirm button
     */
    private void updateValues() {
    	reservationId++;
        int size = Integer.parseInt(partySizeField.getText());
        String name = partyNameField.getText();
        
        
        reservations.add(new Reservation(size, name));
        JOptionPane.showMessageDialog(null,reservations.get(reservations.size()-1));
       
        //for (int i = 0; i < reservations.size(); i++) {

            //Debugging
//            System.out.println(reservations.get(i).getPartyName());
//            System.out.println(reservations.get(i).getPartySize());
//            System.out.println(String.valueOf(reservations.get(i).getReservationId()));

            //partyNameLabelUpdated.setText("Party Name: " + reservations.get(i).getPartyName());
            //partySizeLabelUpdated.setText("Party Size: " + reservations.get(i).getPartySize());
           // numberOfPartiesLabelUpdated.setText("Number of Parties Ahead: " + String.valueOf(reservations.get(i).getReservationId()));
           // numberOfPartiesLabel.setText("Number of Parties Ahead: " + String.valueOf(reservations.get(i).getReservationId()));

           // partyNameLabel.setVisible(true);
           // partyNameField.setVisible(true);
           // partySizeLabel.setVisible(true);
           // partySizeField.setVisible(true);
           
           // numberOfPartiesLabel.setVisible(true);
           // confirm.setVisible(true);
       // }
    }

    private static void setReservations(List<Reservation> res) {
        for(Reservation r : res) {
            reservations.add(r);
        }
    }

    /**
     * Main Method to see how it runs
     */
    public static void main(String args[]) {
        new ReservationPanel(new Restaurant("Panda Express", "Chinese"));
    }
}
