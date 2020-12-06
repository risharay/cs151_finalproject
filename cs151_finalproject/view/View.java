package cs151_finalproject.view;

import javax.swing.*;

import cs151_finalproject.controller.IndividualPanelMessage;
import cs151_finalproject.controller.Message;
import cs151_finalproject.model.Model;
import cs151_finalproject.model.Restaurant;
import cs151_finalproject.controller.ReservationPanelMessage;
import cs151_finalproject.controller.ReviewPanelMessage;
import cs151_finalproject.controller.RestaurantPanelMessage;

import java.awt.*;
import java.util.concurrent.BlockingQueue;

    /**
    * View Class
    */
public class View {
    public static JFrame oldFrame;
    public static Restaurant curr;
    public static String confirmString;
    private BlockingQueue<Message> queue;

    public static JButton viewRestaurant = new JButton("Back");
    public static JButton viewReservation = new JButton("Make a Reservation");
    public static JButton viewReview = new JButton("See Reviews");
    public static JButton viewIndividual = new JButton("Back");

    JButton searchMade = new JButton();
    JButton reservationMade = new JButton();
    JButton reviewMade = new JButton();

    /**
    * Creates object of type view
    * @param queue BlockingQueue of type Message
    * @return queue 
    */
    public static View init(BlockingQueue<Message> queue)
    {
        // Create object of type view
        return new View(queue);
    }

    /**
    * ActionListeners for each view
    * @param queue BlockingQueue of type Message
    */
    private View(BlockingQueue<Message> queue)
    {
        this.queue = queue;
        
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

        viewIndividual.addActionListener(event -> {
            try {
                this.queue.put(new IndividualPanelMessage(oldFrame, curr));       // <-- adding message to the queue
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt(); // fixes the re-interrupt warning
            }
        });
        
    }

   
    /**
    * Changes frame to frame
    * @param f1 first JFrame
    * @param f2 second JFrame
    */
    public static void changeFrame(JFrame f1, JFrame f2)
    {
        f2.setVisible(true);
        f1.dispose();
    }
    /**
    * Sets JFrame
    * @param frame jframe
    */
    public static void setJFrame(JFrame frame) {
        oldFrame = frame;
    } 

    /**
    * Sets current
    * @param restaurant restaurant object
    */
    public static void setCurr(Restaurant restaurant) {
        curr = restaurant;
    }

    /**
    * Sets Confirm Message
    * @param string confirmation string
    */
    public static void setConfirmMessage(String string) {
        confirmString = string;
    }

    /**
    * Make Review Panel
    * @param restaurant restaurant object
    */
    public static JFrame makeReviewPanel(Restaurant restaurant) {
        return new ReviewPanel(restaurant);
    }
    /**
    * Make Reservation Panel
    * @param restaurant restaurant object
    */
    public static JFrame makeReservationPanel(Restaurant restaurant) {
        return new ReservationPanel(restaurant);
    }
    /**
    * Make Restaurant Panel
    * @param model model object
    */
    public static JFrame makeRestaurantPanel(Model model) {
        return new RestaurantPanel(model);
    }
    /**
    * Make Individual Panel
    * @param restaurant restaurant object
    */
    public static JFrame makeIndivPanel(Restaurant restaurant) {
        return new IndividualRestaurantPanel(restaurant);
    }
}