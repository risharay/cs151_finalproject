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

    valves.add(new ReviewPanelValve());
    valves.add(new RestaurantPanelValve());
    valves.add(new ReservationPanelValve());
    valves.add(new MadeReviewValve());
    valves.add(new MadeReservationValve());
    valves.add(new MadeSearchValve());
 }

 public void mainLoop() {
  ValveResponse response = ValveResponse.CONFIRM;
  Message message = null;
  while (response != ValveResponse.FINISH) {
    try {
        message = queue.take(); 
    } catch (InterruptedException e) {
        e.printStackTrace();
        Thread.currentThread().interrupt(); // fixes the re-interrupt warning
    }
      for (Valve valve : valves) {
        response = valve.execute(message);

        if (response != ValveResponse.REJECT) {
          break;
        }
      }
    }
  }

  private interface Valve {
    public ValveResponse execute(Message message);
  }

  private class ReviewPanelValve implements Valve {
    @Override
    public ValveResponse execute(Message message) {
      if (message.getClass() != ReviewPanelMessage.class) {
        return ValveResponse.REJECT;
      }
      // call view to change panel
      return ValveResponse.CONFIRM;
    }
  }

  private class RestaurantPanelValve implements Valve {
    @Override
    public ValveResponse execute(Message message) {
      if (message.getClass() != RestaurantPanelMessage.class) {
        return ValveResponse.REJECT;
      }
      // call view to change panel
      return ValveResponse.CONFIRM;
    }
  }

  private class ReservationPanelValve implements Valve {
    @Override
    public ValveResponse execute(Message message) {
      if (message.getClass() != ReservationPanelMessage.class) {
        return ValveResponse.REJECT;
      }
      // call view to change panel
      // changeFrame(ReservationPanelMessage.getOldFrame(), ReviewPanel(ReservationPanelMessage.getCurr()));
      return ValveResponse.CONFIRM;
    }
  }
  
  private class MadeReviewValve implements Valve {
    @Override
    public ValveResponse execute(Message message) {
      if (message.getClass() != ReviewMadeMessage.class) {
        return ValveResponse.REJECT;
      }
      // create review
      return ValveResponse.CONFIRM;
    }
  }

  private class MadeReservationValve implements Valve {
    @Override
    public ValveResponse execute(Message message) {
      if (message.getClass() != ReservationMadeMessage.class) {
        return ValveResponse.REJECT;
      }
      // create reservation
      return ValveResponse.CONFIRM;
    }
  }

  private class MadeSearchValve implements Valve {
    @Override
    public ValveResponse execute(Message message) {
      if (message.getClass() != SearchMadeMessage.class) {
        return ValveResponse.REJECT;
      }
      // call search
      return ValveResponse.CONFIRM;
    }
  }
}
