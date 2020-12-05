package cs151_finalproject.view;

import javax.swing.*;

import cs151_finalproject.model.Reservation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Reservation Panel where users can make a reservation for the restaurant
 */
public class ReservationPanel extends JFrame {
    private Reservation reservation;
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

    ArrayList<Reservation> reservations;

    /**
     * Design and functions for the Reservation Panel
     *
     * @param partyName Party Name string
     * @param partySize Party Size int
     */
    public ReservationPanel(String partyName, int partySize) {
        this.reservation = reservation;
        this.reservations = new ArrayList<Reservation>();

        partyNamePanel.add(partyNameLabel);
        partyNamePanel.add(partyNameField);
        partyNameField.setText(partyName + "");
        partyNamePanelUpdated.add(partyNameLabelUpdated);

        partySizePanel.add(partySizeLabel);
        partySizePanel.add(partySizeField);
        partySizeField.setText(partySize + "");
        partySizePanelUpdated.add(partySizeLabelUpdated);

        numberOfPartiesPanel.add(numberOfPartiesLabel);
        numberOfPartiesLabel.setText("Number of Parties Ahead: " + String.valueOf(reservationId));

        numberOfPartiesPanelUpdated.add(numberOfPartiesLabelUpdated);

        confirm = new JButton("Confirm");
        back = new JButton("Back");

        confirm.addActionListener(confirm -> updateValues());
        back.addActionListener(back -> goBack());


        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setSize(500, 500);
        frame.add(partyNamePanel, JFrame.LEFT_ALIGNMENT);
        frame.add(partyNamePanelUpdated, JFrame.LEFT_ALIGNMENT);
        frame.add(partySizePanel, JFrame.LEFT_ALIGNMENT);
        frame.add(partySizePanelUpdated, JFrame.LEFT_ALIGNMENT);
        frame.add(numberOfPartiesPanel, JFrame.LEFT_ALIGNMENT);
        frame.add(numberOfPartiesPanelUpdated, JFrame.LEFT_ALIGNMENT);
        frame.add(confirm);
        frame.add(back);
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

        
        reservations.add(new Reservation(reservationId, size, name));
        JOptionPane.showMessageDialog(null,"Party Name: " +reservations.get(reservations.size()-1).getPartyName() + " Party Size: " + reservations.get(reservations.size()-1).getPartySize() + " Number of Parties Ahead: " + reservations.get(reservations.size()-1).getReservationId());
       
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

    /**
     * Goes back to main page when user presses confirm button
     */
    private void goBack() {
        // TO DO
    }

    /**
     * Main Method to see how it runs
     */
    public static void main(String args[]) {
        Reservation reservation = new Reservation(0, 0, null);
        ReservationPanel reservationFrame = new ReservationPanel(null, 0);
    }
}
