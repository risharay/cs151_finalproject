package cs151_finalproject.view;

import cs151_finalproject.model.Review;
import cs151_finalproject.model.Restaurant;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class ReviewPanel extends JFrame {
    static List<Review> reviews = new ArrayList<>();

    // public void addActionListener(ActionListener a){
    //     submitButton.addActionListener(a);
    // }

    public void update() {
        if(!nameInput.getText().isBlank() && !ratingInput.getText().isBlank() && !reviewInput.getText().isBlank()) {
            Review temp = new Review(Integer.parseInt(ratingInput.getText()), reviewInput.getText(), nameInput.getText());
            reviews.add(temp);
            initializeReviewLabels();
        } 
    }

    // the frame itself
    public ReviewPanel(Restaurant restaurant) {
        View.setJFrame(this);
        setReviews(restaurant.getReviews());
        
        restaurantName.setText(restaurant.getName());
        restaurantName.setFont(new Font("Arial", Font.BOLD, 20));
        
        titleLabel.setFont(new Font("Arial", Font.BOLD, 15));
        titleLabel.setBorder(new EmptyBorder(10,0,10,0));
        
    	JPanel headerPanel = new JPanel();
    	headerPanel.add(restaurantName);
    	headerPanel.add(titleLabel);
    	
    	
        JFrame frame = new JFrame();
  
        frame.add(headerPanel, BorderLayout.NORTH);
 
        frame.add(formPanel());
        initializeReviewLabels();

        // implement a scroll pane that appears when the list gets longer than allocated size
        scrollPane = new JScrollPane(reviewJList);
        Container contentPane = frame.getContentPane();         
        contentPane.add(scrollPane, BorderLayout.WEST); 
  
        frame.add(View.viewIndividual, BorderLayout.SOUTH);
        frame.setPreferredSize(new Dimension(500, 500));   
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private static void setReviews(List<Review> rev) {
        for(Review r : rev) {
            reviews.add(r);
        }
    }

    // sets up the JList of reviews and adds additional configurations
    // e.g. * disables selection (view only)
    public void initializeReviewLabels() {
        // clears the list and reinitializes it due to error with the automatic refresh of JList
            reviewJList = new JList<>(model);
        for (Review r : reviews) {
            model.addElement(r);
        }
        reviewJList.setModel(model);
        reviewJList.setCellRenderer(new MyListCellRenderer());
    
        reviewJList.setSelectionModel(new DisabledItemSelectionModel());
    }
    
    // the submission panel for users to input:
    // name, rating, and comment
    public JPanel formPanel() {    	
    	JPanel namePanel = new JPanel();
        namePanel.add(nameLabel);
        namePanel.add(nameInput);

        JPanel detailPanel = new JPanel();
        detailPanel.add(ratingLabel);
        detailPanel.add(ratingInput);

        JPanel reviewPanel = new JPanel();
        reviewPanel.add(reviewLabel);
        reviewPanel.add(reviewInput);


        submitButton.addActionListener(e -> update());

        JPanel formPanel = new JPanel();

        formPanel.add(namePanel);
        formPanel.add(detailPanel);
        formPanel.add(reviewPanel);
        formPanel.add(submitButton);
        
        return formPanel;
    }

    // variables
    private JLabel nameLabel = new JLabel("Name: ");
    private JLabel ratingLabel = new JLabel("Rating: ");
    private JLabel reviewLabel = new JLabel("Review: ");
    private JLabel restaurantName = new JLabel();
    private JLabel titleLabel = new JLabel("Make A Review: ");
    private JTextField nameInput = new JTextField(5);
    private JTextField ratingInput = new JTextField(1);
    private JTextField reviewInput = new JTextField(10);
    private JButton submitButton = new JButton("Submit");

    private DefaultListModel<Review> model =  new DefaultListModel<>();
    private JList<Review> reviewJList = new JList<>(model);
    JScrollPane scrollPane = new JScrollPane(reviewJList);

}

// disable default selection model in JList
@SuppressWarnings("serial")
class DisabledItemSelectionModel extends DefaultListSelectionModel {

    @Override
    public void setSelectionInterval(int index0, int index1) {
        super.setSelectionInterval(-1, -1);
    }
}

// creates each cell in the JList
// looks cleaner and handles the conversion of review's toString()
@SuppressWarnings("serial")
class MyListCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(
            JList list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        Review label = (Review) value;
        String labelText = label.toString();
        setText(labelText);

        return this;
    }
}