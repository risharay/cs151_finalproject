import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// import java.text.SimpleDateFormat;  
// import java.util.Date;  

public class ReviewPanel extends JFrame {
    public static ArrayList<Review> reviews = new ArrayList<>();
    // SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
    // Date date = new Date();  

    public void addActionListener(ActionListener a){
        submitButton.addActionListener(a);
    }

    public ReviewPanel() {
        JFrame frame = new JFrame();
        frame.add(formPanel(), BorderLayout.NORTH);
        initializeReviewLabels();

        // implement a scroll pane that appears when the list gets longer than allocated size
        scrollPane = new JScrollPane(reviewJList);
        Container contentPane = frame.getContentPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void initializeReviewLabels() {
        model.clear();
        reviewJList = new JList(model);
        for (Review r : reviews) {
            model.addElement(r);
        }
        reviewJList.setModel(model);
        reviewJList.setCellRenderer(new MyListCellRenderer());
        // Review temp = new Review (5, "John Doe", "Test");
        
        // resJList.add(temp);

        reviewJList.setSelectionModel(new DisabledItemSelectionModel());
    }

    public JPanel formPanel() {
        JPanel namePanel = new JPanel();
        namePanel.add(nameLabel);
        namePanel.add(nameInput);

        JPanel detailPanel = new JPanel();
        detailPanel.add(ratingLabel);
        detailPanel.add(ratingInput);
        // dateLabel.setText(formatter.format(date));
        // detailPanel.add(dateLabel);

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

        reviews.add(new Review(5, "Perfect!", "John Doe"));
        reviews.add(new Review(4, "So-so food, but great people.", "Jane Doe"));
        reviews.add(new Review(1, "Abolutely horrible >:(", "Bad Reviewer"));

        ReviewPanel graph = new ReviewPanel();
        graph.setSize(500, 500);

    }

    private JLabel nameLabel = new JLabel("Name: ");
    private JLabel ratingLabel = new JLabel("Rating: ");
    private JLabel reviewLabel = new JLabel("Review: ");
    // private JLabel dateLabel;
    private JTextField nameInput = new JTextField(5);
    private JTextField ratingInput = new JTextField(1);
    private JTextField reviewInput = new JTextField(10);
    private JButton submitButton = new JButton("Submit");

    private DefaultListModel model =  new DefaultListModel();
    private JList<Review> reviewJList = new JList(model);
    JScrollPane scrollPane = new JScrollPane(reviewJList);

}

// disable default selection model in JList
class DisabledItemSelectionModel extends DefaultListSelectionModel {

    @Override
    public void setSelectionInterval(int index0, int index1) {
        super.setSelectionInterval(-1, -1);
    }
}

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