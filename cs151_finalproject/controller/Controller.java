package cs151_finalproject.controller;

import cs151_finalproject.model.Model;
import cs151_finalproject.view.RestaurantPanel;
import cs151_finalproject.view.View;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
/**
 * Controller
 */
public class Controller {
  private BlockingQueue<Message> queue;
  private View view; // Direct reference to view
  private Model model; // Direct reference to model
  private List<Valve> valves = new LinkedList<Valve>();

  /**
   * Controller constructor
   * @param view
   * @param model
   * @param queue
   */
  public Controller(View view, Model model, BlockingQueue<Message> queue) {
    this.view = view;
    this.model = model;
    this.queue = queue;

    valves.add(new ReviewPanelValve());
    valves.add(new RestaurantPanelValve());
    valves.add(new ReservationPanelValve());
    valves.add(new IndividualPanelValve());
    
    new RestaurantPanel(model);
 }

  /**
   * Main Loop
   */
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

 /**
  * Valve Interface
  */
  private interface Valve {
    public ValveResponse execute(Message message);
  }

  /**
   * Review Panel Valve
   */
  private class ReviewPanelValve implements Valve {
    
	  /**
	   * Execute Valve Response
	   * @param message
	   * @return Valve Response
	   */
	@Override
    public ValveResponse execute(Message message) {
      if (message.getClass() != ReviewPanelMessage.class) {
        return ValveResponse.REJECT;
      }
      ReviewPanelMessage input = (ReviewPanelMessage)message;
      View.changeFrame(input.getOldFrame(), View.makeReviewPanel(input.getCurr()));
      return ValveResponse.CONFIRM;
    }
  }

  /**
   * Restaurant Panel Valve
   */
  private class RestaurantPanelValve implements Valve {
    
	  /**
	   * Execute Valve Response
	   * @param message
	   * @return Valve Response
	   */
	@Override
    public ValveResponse execute(Message message) {
      if (message.getClass() != RestaurantPanelMessage.class) {
        return ValveResponse.REJECT;
      }
      RestaurantPanelMessage input = (RestaurantPanelMessage)message;
      View.changeFrame(input.getOldFrame(), View.makeRestaurantPanel(model));
      return ValveResponse.CONFIRM;
    }
  }
  /**
   * Reservation Panel Valve
   */
  private class ReservationPanelValve implements Valve {
	  /**
	   * Execute Valve Response
	   * @param message
	   * @return Valve Response
	   */
	  
	 @Override
    public ValveResponse execute(Message message) {
      if (message.getClass() != ReservationPanelMessage.class) {
        return ValveResponse.REJECT;
      }

      ReservationPanelMessage input = (ReservationPanelMessage)message;
      View.changeFrame(input.getOldFrame(), View.makeReservationPanel(input.getCurr()));
      return ValveResponse.CONFIRM;
    }
  }

  /**
   * Individual Panel Valve
   */
  private class IndividualPanelValve implements Valve {
	  /**
	   * Execute Valve Response
	   * @param message
	   * @return Valve Response
	   */
	  
	 @Override
    public ValveResponse execute(Message message) {
      if (message.getClass() != IndividualPanelMessage.class) {
        return ValveResponse.REJECT;
      }

      IndividualPanelMessage input = (IndividualPanelMessage)message;
      View.changeFrame(input.getOldFrame(), View.makeIndivPanel(input.getCurr()));
      return ValveResponse.CONFIRM;
    }
  }
}
