package cs151_finalproject.view;

import javax.swing.*;

import cs151_finalproject.controller.Message;
import cs151_finalproject.controller.ReservationMadeMessage;
import cs151_finalproject.controller.ReviewMadeMessage;
import cs151_finalproject.controller.SearchMadeMessage;
import cs151_finalproject.model.Restaurant;
import cs151_finalproject.controller.ReservationPanelMessage;
import cs151_finalproject.controller.ReviewPanelMessage;
import cs151_finalproject.controller.RestaurantPanelMessage;

import java.awt.*;
import java.util.concurrent.BlockingQueue;

public class View {
    public static JFrame oldFrame;
    public static Restaurant curr;
    public static String confirmString;

    private JFrame mainFrame;
    private BlockingQueue<Message> queue;

    public static JButton viewRestaurant = new JButton("Back");
    public static JButton viewReservation = new JButton("Make a Reservation");
    public static JButton viewReview = new JButton("See Reviews");
    JButton searchMade = new JButton();
    JButton reservationMade = new JButton();
    JButton reviewMade = new JButton();

    public static int FRAME_WIDTH = 300;
    public static int FRAME_HEIGHT = 500;

    public static View init(BlockingQueue<Message> queue)
    {
        // Create object of type view
        return new View(queue);
    }

    private View(BlockingQueue<Message> queue)
    {
        this.queue = queue;
        // TODO:
        // you should initalize JFrame and show it,
        // JFrame should be able to add Messages to queue
        // JFrame can be in a separate class or created JFrame with all the elements in this class
        // or you can make View a subclass of JFrame by extending it
        mainFrame = new JFrame();

        viewRestaurant.addActionListener(event -> {
            try {
                this.queue.put(new RestaurantPanelMessage(oldFrame, curr));   // <-- adding message to the queue
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt(); // fixes the re-interrupt warning
            }
        });

        viewReservation.addActionListener(event -> {
            try {
                this.queue.put(new ReservationPanelMessage(oldFrame, curr));  // <-- adding message to the queue
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt(); // fixes the re-interrupt warning
            }
        });

        viewReview.addActionListener(event -> {
            try {
                this.queue.put(new ReviewPanelMessage(oldFrame, curr));       // <-- adding message to the queue
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt(); // fixes the re-interrupt warning
            }
        });
        

        // /*
        // * commented out because not sure if these should be here or in the panels themselves?
        // * since the actual buttons should be in their respective panels unless im trippin' lol
        // *

        searchMade.addActionListener(event -> {
            try {
                this.queue.put(new SearchMadeMessage(confirmString));
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt(); // fixes the re-interrupt warning
            }
        });

        reservationMade.addActionListener(event -> {
            try {
                this.queue.put(new ReservationMadeMessage(confirmString));
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt(); // fixes the re-interrupt warning
            }
        });

        reviewMade.addActionListener(event -> {
            try {
                ReviewPanel.update();
                this.queue.put(new ReviewMadeMessage(confirmString));
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt(); // fixes the re-interrupt warning
            }
        });
        

        // add everything and set layout and other standard JFrame settings
        // mainFrame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        // mainFrame.setSize(500,500);

        // // would add buttons here but i forgot how we are like making a start page or ..?
        // //
        // //

        // mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // mainFrame.pack();
        // mainFrame.setVisible(true);

        new IndividualRestaurantPanel(new Restaurant("Panda Express", "Chinese"));
    }

    public static void changeFrame(JFrame f1, JFrame f2)
    {
    	System.out.println(f1.getLocation());
    	System.out.println(f2.getLocation());
    	f2.setLocation(f1.getLocation());
    	System.out.println(f2.getLocation());
        f2.setVisible(true);
        f1.dispose();
    }

    public static void setJFrame(JFrame frame) {
        oldFrame = frame;
    } 

    public static void setCurr(Restaurant restaurant) {
        curr = restaurant;
    }

    public static void setConfirmMessage(String string) {
        confirmString = string;
    }

    public static JFrame makeReviewPanel(Restaurant restaurant) {
        return new ReviewPanel(restaurant);
    }

    public static JFrame makeReservationPanel(Restaurant restaurant) {
        return new ReservationPanel(restaurant);
    }

    public static JFrame makeRestaurantPanel() {
        return new RestaurantPanel();
    }

    public static JFrame makeIndivPanel(Restaurant restaurant) {
        return new IndividualRestaurantPanel(restaurant);
    }
}