package cs151_finalproject.view;


import javax.swing.*;

import cs151_finalproject.model.Review;
import cs151_finalproject.model.Restaurant;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class ReviewPanel extends JFrame {
    static List<Review> reviews = new ArrayList<>();

    public void addActionListener(ActionListener a){
        submitButton.addActionListener(a);
    }

    // the frame itself
    public ReviewPanel(Restaurant restaurant) {
        setReviews(restaurant.getReviews());
        
        JFrame frame = new JFrame();
        frame.add(formPanel(), BorderLayout.NORTH);
        initializeReviewLabels();

        // implement a scroll pane that appears when the list gets longer than allocated size
        scrollPane = new JScrollPane(reviewJList);
        Container contentPane = frame.getContentPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        frame.add(backButton, BorderLayout.SOUTH);

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
        model.clear();
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

        submitButton.addActionListener(e -> {
            if(!nameInput.getText().isBlank() && !ratingInput.getText().isBlank() && !reviewInput.getText().isBlank()) {
                Review temp = new Review(Integer.parseInt(ratingInput.getText()), reviewInput.getText(), nameInput.getText());
                reviews.add(temp);
                initializeReviewLabels();
            } 
        });

        JPanel formPanel = new JPanel();
        formPanel.add(namePanel);
        formPanel.add(detailPanel);
        formPanel.add(reviewPanel);
        formPanel.add(submitButton);

        return formPanel;
    }

    public static void main(String[] args) {
        // String name, String cuisine, int location, double rating
        Restaurant test = new Restaurant("Panda Express", "Chinese", 3, 3.5);
        test.makeReview(new Review(5, "Perfect!", "John Doe"));
        test.makeReview(new Review(4, "So-so food, but great people.", "Jane Doe"));
        test.makeReview(new Review(1, "Abolutely horrible >:(", "Bad Reviewer"));

        ReviewPanel graph = new ReviewPanel(test);
        graph.setSize(500, 500);

    }

    // variables
    private JLabel nameLabel = new JLabel("Name: ");
    private JLabel ratingLabel = new JLabel("Rating: ");
    private JLabel reviewLabel = new JLabel("Review: ");

    private JTextField nameInput = new JTextField(5);
    private JTextField ratingInput = new JTextField(1);
    private JTextField reviewInput = new JTextField(10);
    private JButton submitButton = new JButton("Submit");
    private JButton backButton = new JButton("Back");

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