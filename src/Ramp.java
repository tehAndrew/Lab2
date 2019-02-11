public class Ramp {
    private double minAngle;
    private double maxAngle;
    private double neutralAngle;
    private double angle;

    public Ramp(double minAngle, double maxAngle, double neutralAngle) {
        this.maxAngle = maxAngle;
        this.minAngle = minAngle;
        this.neutralAngle = neutralAngle;
        angle = minAngle;
    }

    public void raise() {
        angle = maxAngle;
    }

    public void lower() {
        angle = minAngle;
    }

    public void raise(double angle) {
        if (this.angle + angle > maxAngle) { raise(); }
        else { this.angle += angle; }
    }

    public void lower(double angle) {
        if (this.angle - angle < maxAngle) { lower(); }
        else {this.angle -= angle;}
    }

    public boolean isInNeutralPos() {
        return angle == minAngle;
    }
}