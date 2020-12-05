package cs151_finalproject;

import cs151_finalproject.controller.Controller;
import cs151_finalproject.controller.Message;
import cs151_finalproject.model.Model;
import cs151_finalproject.view.View;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Yum {
    private static BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
    // private static View view;
    // private static Model model;

    public static void main(String[] args) {
        View view = View.init(queue);
        Model model = new Model();
        Controller controller = new Controller(view, model, queue);

        controller.mainLoop();
        view.dispose();
        queue.clear();
    }
}
// 