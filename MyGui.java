import ecs100.*;
import java.awt.Color;
import javax.swing.JColorChooser;
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
    
    // remember the color 
    private Color currentColor = Color.black;

    /**
     * Constructor for objects of class MyGui
     */
    public MyGui()
    {
        // initialise instance variables
        speed = 0;
        
        // set up buttons 
        UI.addButton("quit", UI::quit);
        UI.addButton("clear screen", UI::clearGraphics);
        
        // color buttons 
        UI.addButton("color", this::chooseColor);
        UI.addButton("random color", this::changeColor);
        
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
        double width = speed; 
        double height = speed; 
        if (action.equals("pressed")) {
            this.startX = x;
            this.startY = y;
        } else if (action.equals("released")) {
            UI.drawLine(this.startX, this.startY, x, y);
        } else if (action.equals("clicked")) {
            UI.fillOval(x-width/2, y-height/2, width, height);
        }
    }
    
    /**
     *  change to a random colour
     */
    public void changeColor() {
        // random rgb value
        Color col = new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
        // set color
        UI.setColor(col);
    }
    
    /**
     *  choose color using the swing library 
     */
    public void chooseColor() {
        this.currentColor = JColorChooser.showDialog(null, "Choose Color", this.currentColor);
        UI.setColor(this.currentColor);
    }
}
