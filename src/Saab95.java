/* Saab95.java
 * 2019-01-31
 */

import java.awt.*;

public class Saab95 extends Vehicle {
    private boolean turboOn;

    public Saab95(){
        super(2, 125, Color.red, "Saab95", 4.16, 1.57);
        turboOn = false;
    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    public double speedFactor(){
        double turbo = 1;
        if(turboOn) { turbo = 1.3; }
        return getEnginePower() * 0.01 * turbo;
    }

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }
}