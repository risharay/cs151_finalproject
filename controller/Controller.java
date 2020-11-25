package cs151_finalproject.controller;

import cs151_finalproject.model.Model;
import cs151_finalproject.view.View;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Controller {
    private BlockingQueue<Message> queue;
    private View view; // Direct reference to view
    private Model model; // Direct reference to model

    private List<Valve> valves = new LinkedList<Valve>();

    public Controller(View view, Model model, BlockingQueue<Message> queue) {
        this.view = view;
        this.model = model;
        this.queue = queue;
        // example
        // valves.add(new DoNewGameValve());
        // valves.add(new DoHitValve());
    }

    public void mainLoop() {
        ValveResponse response = ValveResponse.EXECUTED;
        Message message = null;
        while (response != ValveResponse.FINISH) {
            try {
                message = queue.take(); // <--- take next message from the queue
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Look for a Valve that can process a message
            for (Valve valve : valves) {
                response = valve.execute(message);
                // if successfully processed or game over, leave the loop
                if (response != ValveResponse.MISS) {
                    break;
                }
            }
        }
    }

    private interface Valve {
        /**
         * Performs certain action in response to message
         */
        public ValveResponse execute(Message message);
    }

    // example
    // private class DoHitValve implements Valve {
    //     @Override
    //     public ValveResponse execute(Message message) {
    //         if (message.getClass() != HitMessage.class) {
    //             return ValveResponse.MISS;
    //         }
    //         // otherwise message is of HitMessage type
    //         // actions in Model and View
    //         return ValveResponse.EXECUTED;
    //     }
    // }
}
