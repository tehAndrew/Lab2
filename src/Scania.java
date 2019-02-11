import java.awt.*;

public class Scania extends Vehicle {
    private Ramp flatBed;

    public Scania(){
        super(2, 730, Color.yellow, "Scania", 8.53, 2.44);
        flatBed = new Ramp(0, 70, 0);
    }

    public void raiseFlatbed(double angle) {
        if (getCurrentSpeed() == 0) { flatBed.raise(angle); }
    }

    public void lowerFlatbed(double angle) {
        if (getCurrentSpeed() == 0) { flatBed.lower(angle); }
    }

    public double speedFactor(){
        return flatBed.isInNeutralPos() ? getEnginePower() * 0.01 : 0;
    }

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

}
