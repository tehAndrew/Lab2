import java.awt.*;

public class Scania extends Vehicle {

    public Scania(){

        super(2, 125, Color.red, "Saab95");
    }

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

}
