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
    // instance variables - replace the example below with your own
    private double speed;

    /**
     * Constructor for objects of class MyGui
     */
    public MyGui()
    {
        // initialise instance variables
        speed = 0;
        
        // set up buttons 
        UI.addButton("quit", UI::quit);
        
        UI.addSlider("speed", 0, 100, 20, this::setSpeed);
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
}
