import ecs100.*;
import java.awt.Color;
/**
 * making some sliders and responding to mouse events
 *
 * @author CC
 * @version 07/03/23
 */
public class MyGui
{
    // instance variables 
    private double speed;
    
    // fields to remember the pressed position
    private double startX, startY;

    /**
     * Constructor for objects of class MyGui
     */
    public MyGui()
    {
        // initialise instance variables
        speed = 0;
        
        // set up buttons 
        UI.addButton("quit", UI::quit);
        
        // set up slider 
        UI.addSlider("speed", 0, 100, 20, this::setSpeed);
        
        // set mouse listener 
        UI.setLineWidth(10);
        UI.setMouseListener(this::doMouse);
    }

    /**
     * callback method for speed slider 
     */
    public void setSpeed(double km) {
        // check if it is greater of less than last speed 
        if(speed < km) {
            UI.println("vrooooooom vroooooooooom");
        } else if (speed > km) {
            UI.println("vroom vrom");
        } else {
            UI.println("no moving");
        }
        
        // set the speed to the new speed
        this.speed = km; 
    }
    
    /**
     * Callback method for mouse listener 
     * only make 1 callback method for mouse listener 
     */
    public void doMouse(String action, double x, double y) {
        if (action.equals("pressed")) {
            this.startX = x;
            this.startY = y;
        } else if (action.equals("released")) {
            UI.drawLine(this.startX, this.startY, x, y);
        } else if (action.equals("clicked")) {
        
        }
    }
}
