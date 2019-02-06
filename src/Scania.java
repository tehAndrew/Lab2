import java.awt.*;

public class Scania extends Vehicle {
    private double flatbedAngle;

    public Scania(){
        super(2, 730, Color.blue, "Scania");
        flatbedAngle = 0;
    }

    public double getFlatbedAngle() {
        return flatbedAngle;
    }

    public void raiseFlatbed(double angle) {
        if (currentSpeed == 0) {
            flatbedAngle = Math.min(flatbedAngle + angle, 70);
        }
    }

    public void lowerFlatbed(double angle) {
        flatbedAngle = Math.max(flatbedAngle - angle, 0);
    }

    public double speedFactor(){
        return flatbedAngle > 0 ? 0 : enginePower * 0.01;
    }

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

}
