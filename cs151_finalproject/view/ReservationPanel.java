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

    private JFrame frame = new JFrame();
    private JPanel partyNamePanel = new JPanel();
    private JPanel partyNamePanelUpdated = new JPanel();
    private JPanel partySizePanel = new JPanel();
    private JPanel partySizePanelUpdated = new JPanel();
    private JPanel numberOfPartiesPanel = new JPanel();
    private JPanel numberOfPartiesPanelUpdated = new JPanel();

    private JButton confirm;
    private JButton back;

    static List<Reservation> reservations = new ArrayList<>();

    /**
     * Design and functions for the Reservation Panel
     * @param restaurant Restaurant object
     */
    public ReservationPanel(Restaurant restaurant) {
        View.setJFrame(this);
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
        numberOfPartiesLabel.setText("Number of Parties Ahead: " + restaurant.getReservations().size());      

        numberOfPartiesPanelUpdated.add(numberOfPartiesLabelUpdated);

        confirm = new JButton("Confirm");
        back = new JButton("Back");
        
        JPanel buttons = new JPanel();
        buttons.add(confirm);
        buttons.add(View.viewIndividual);

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
        frame.add(buttons);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    /**
     * Reservation List update process when user presses confirm button
     */
    private void updateValues() {
        if(!partyNameField.getText().isBlank() && !partySizeField.getText().isBlank()) {
            int size = Integer.parseInt(partySizeField.getText());
            String name = partyNameField.getText();
            
            
            reservations.add(new Reservation(size, name));
            numberOfPartiesLabel.setText("Number of Parties Ahead: " + reservations.size()); 
            JOptionPane.showMessageDialog(null,"Reservation Made\n" + reservations.get(reservations.size()-1));
        } else {
            JOptionPane.showMessageDialog(null,"Reservation parameters incomplete");
        }
    }

    /**
     * adds the reservation to Reservation
     * @res reservation from the list of reservations
     */
    private static void setReservations(List<Reservation> res) {
        for(Reservation r : res) {
            reservations.add(r);
        }
    }
}
