package cs151_finalproject.view;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

public class View {
    private JFrame mainFrame;
    private BlockingQueue<Message> queue;

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

        JButton viewRestaurant = new JButton();
        JButton viewReservation = new JButton();
        JButton viewReview = new JButton();

        viewRestaurant.addActionListener(event -> {
            try {
                this.queue.put(new RestaurantPanelMessage());   // <-- adding message to the queue
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        viewReservation.addActionListener(event -> {
            try {
                this.queue.put(new ReservationPanelMessage());  // <-- adding message to the queue
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        viewReview.addActionListener(event -> {
            try {
                this.queue.put(new ReviewPanelMessage());       // <-- adding message to the queue
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        /*
        * commented out because not sure if these should be here or in the panels themselves?
        * since the actual buttons should be in their respective panels unless im trippin' lol
        *
        JButton searchMade = new JButton();
        JButton reservationMade = new JButton();
        JButton reviewMade = new JButton();

        searchMade.addActionListener(event -> {
            try {
                this.queue.put(new SearchMadeMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        reservationMade.addActionListener(event -> {
            try {
                this.queue.put(new ReservationMadeMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        reviewMade.addActionListener(event -> {
            try {
                this.queue.put(new ReviewMadeMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
         */

        // add everything and set layout and other standard JFrame settings
        mainFrame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        mainFrame.setSize(500,500);

        // would add buttons here but i forgot how we are like making a start page or ..?
        //
        //

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public void change() {
        // TODO: do all the updates and repaint
        //gameFrame.repaint();
    }

    public void dispose() {
        // TODO: clear all the resources
        // for example, gameFrame.dispose();
    }
}
