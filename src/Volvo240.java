/* Vehicle.java
 * 2019-01-31
 */
import java.awt.*;

public class Volvo240 extends Vehicle {

    public final static double trimFactor = 1.25;

    public Volvo240(){
        super(4, 100, Color.BLACK, "Volvo240", 4.9, 1.71);
    }

    public double speedFactor(){
        return this.getEnginePower() * 0.01 * trimFactor;
    }

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, this.getEnginePower());
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

}
