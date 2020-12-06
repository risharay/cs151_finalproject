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

    public static View init(BlockingQueue<Message> queue)
    {
        // Create object of type view
        return new View(queue);
    }

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

    public static void changeFrame(JFrame f1, JFrame f2)
    {
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

    public static JFrame makeRestaurantPanel(Model model) {
        return new RestaurantPanel(model);
    }

    public static JFrame makeIndivPanel(Restaurant restaurant) {
        return new IndividualRestaurantPanel(restaurant);
    }
}