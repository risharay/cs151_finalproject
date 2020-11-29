import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * Panel to Make a reservation
 *
 */

public class ReservationPanel extends JFrame {
    private Reservation reservation;
    private JLabel partyNameLabel = new JLabel("Party Name ");
    private JLabel partyNameLabelUpdated = new JLabel();
    private JLabel partySizeLabel = new JLabel("Party Size: ");
    private JLabel partySizeLabelUpdated = new JLabel();
    private JLabel numberOfPartiesLabel = new JLabel("Number of Parties Ahead: ");
    private JLabel numberOfPartiesLabelUpdated = new JLabel();
    private JTextField partyNameField = new JTextField(10);
    private JTextField partySizeField = new JTextField(10);


    int reservationId;
    JPanel partySizePanel = new JPanel();

    private JButton confirm;
    private JButton back;

    ArrayList<Reservation> reservations;

    public ReservationPanel(String n1, int n2) {
        this.reservation = reservation;
        this.reservations = new ArrayList<Reservation>();

        JPanel partyNamePanel = new JPanel();
        partyNamePanel.add(partyNameLabel);
        partyNamePanel.add(partyNameField);
        partyNameField.setText(n1 + "");


        JPanel partyNamePanelUpdated = new JPanel();
        partyNamePanel.add(partyNameLabelUpdated);

        partySizePanel.add(partySizeLabel);
        partySizePanel.add(partySizeField);
        partySizeField.setText(n2 + "");


        JPanel partySizePanelUpdated = new JPanel();
        partyNamePanel.add(partySizeLabelUpdated);


        JPanel numberOfPartiesPanel = new JPanel();
        numberOfPartiesPanel.add(numberOfPartiesLabel);


        JPanel numberOfPartiesPanelUpdated = new JPanel();
        partyNamePanel.add(numberOfPartiesLabelUpdated);


        confirm = new JButton("Confirm");
        back = new JButton("Back");

        confirm.addActionListener(confirm -> updateValues());
        back.addActionListener(back -> goBack());
        JFrame frame = new JFrame();
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setSize(500,500);
        frame.add(partyNamePanel, JFrame.LEFT_ALIGNMENT);
        frame.add(partyNamePanelUpdated);
        frame.add(partySizePanel, JFrame.LEFT_ALIGNMENT);
        frame.add(partySizePanelUpdated);
        frame.add(numberOfPartiesPanel, JFrame.LEFT_ALIGNMENT);
        frame.add(numberOfPartiesPanelUpdated);
        frame.add(confirm);
        frame.add(back);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setVisible(true);

    }



    private void updateValues() {
        reservationId++;
        int size = Integer.parseInt(partySizeField.getText());
        String name = partyNameField.getText();

        partySizePanel.remove(partySizeField);
        reservations.add(new Reservation(reservationId, size, name));
        for (int i = 0; i < reservations.size(); i++) {


            partyNameLabelUpdated.setText("Party Name: " + reservations.get(i).getPartyName());
            System.out.println(reservations.get(i).getPartyName());
            //reservation.setPartySize(reservations.get(i).getPartySize());
            partySizeLabelUpdated.setText("Party Size: " + reservations.get(i).getPartySize());
            numberOfPartiesLabelUpdated.setText("Number of Parties Ahead: " + String.valueOf(reservations.get(i).getReservationId()));
            numberOfPartiesLabel.setText("Number of Parties Ahead: " + String.valueOf(reservations.get(i).getReservationId()));
            partyNameLabel.setVisible(false);
            partyNameField.setVisible(false);
            partySizeLabel.setVisible(false);
            partySizeField.setVisible(false);
            confirm.setVisible(false);


        }


    }
    private void goBack(){
        //go back to restaurant page
    }
    public static void main(String args[]) {
        Reservation reservation = new Reservation(0,0,null);
        ReservationPanel reservationFrame = new ReservationPanel(null,0);
        // ConfirmationPanel confirmationPanelFrame = new ConfirmationPanel(reservation);



    }
}