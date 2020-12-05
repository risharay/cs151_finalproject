package cs151_finalproject.view;

import javax.swing.*;

import cs151_finalproject.controller.Message;
import cs151_finalproject.controller.ReservationMadeMessage;

import java.awt.*;
import java.util.concurrent.BlockingQueue;

public class View {
    private JFrame gameFrame;
    private BlockingQueue<Message> queue;

    public static View init(BlockingQueue<Message> queue) {
        // Create object of type view
        return new View(queue);
    }

    private View(BlockingQueue<Message> queue) {
        this.queue = queue;
        // TODO:
        // you should initalize JFrame and show it,
        // JFrame should be able to add Messages to queue
        // JFrame can be in a separate class or created JFrame with all the elements in this class
        // or you can make View a subclass of JFrame by extending it
        gameFrame = new JFrame();

        JButton newGame = new JButton("New Game");
        JButton hitButton = new JButton("hit");

        newGame.addActionListener(event -> {
            try {
                this.queue.put(new ReservationMadeMessage(true)); // <--- adding NewGame message to the queue
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // add everything and set layout and other standard JFrame settings
        gameFrame.add(newGame);
        gameFrame.add(hitButton);
        gameFrame.pack();
        gameFrame.setLayout(new FlowLayout());
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
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
