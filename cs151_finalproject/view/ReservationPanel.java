package cs151_finalproject.view;

import javax.swing.*;

import cs151_finalproject.model.Reservation;
import cs151_finalproject.model.Restaurant;

import java.util.List;
import java.util.ArrayList;

/**
 * Reservation Panel where users can make a reservation for the restaurant
 */
public class ReservationPanel extends JFrame {
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

        partyNamePanel.add(partyNameLabel);
        partyNamePanel.add(partyNameField);
        partyNamePanelUpdated.add(partyNameLabelUpdated);

        partySizePanel.add(partySizeLabel);
        partySizePanel.add(partySizeField);
        partySizePanelUpdated.add(partySizeLabelUpdated);

        numberOfPartiesPanel.add(numberOfPartiesLabel);
        numberOfPartiesLabel.setText("Number of Parties Ahead: " + String.valueOf(reservationId));

        numberOfPartiesPanelUpdated.add(numberOfPartiesLabelUpdated);

        confirm = new JButton("Confirm");
        back = new JButton("Back");

        confirm.addActionListener(confirm -> updateValues());

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

        partySizePanel.remove(partySizeField);
        reservations.add(new Reservation(reservationId, size, name));
        for (int i = 0; i < reservations.size(); i++) {

            //Debugging
            System.out.println(reservations.get(i).getPartyName());
            System.out.println(reservations.get(i).getPartySize());
            System.out.println(String.valueOf(reservations.get(i).getReservationId()));

            partyNameLabelUpdated.setText("Party Name: " + reservations.get(i).getPartyName());
            partySizeLabelUpdated.setText("Party Size: " + reservations.get(i).getPartySize());
            numberOfPartiesLabelUpdated.setText("Number of Parties Ahead: " + String.valueOf(reservations.get(i).getReservationId()));
            numberOfPartiesLabel.setText("Number of Parties Ahead: " + String.valueOf(reservations.get(i).getReservationId()));

            partyNameLabel.setVisible(false);
            partyNameField.setVisible(false);
            partySizeLabel.setVisible(false);
            partySizeField.setVisible(false);
            numberOfPartiesLabel.setVisible(false);
            confirm.setVisible(false);
        }
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
        ReservationPanel reservationFrame = new ReservationPanel();
    }
}
